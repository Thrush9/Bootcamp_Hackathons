package com.stackroute.LibraryService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import com.stackroute.LibraryRepository.LibraryRepository;
import com.stackroute.LibraryRepository.iLibraryRepository;
import com.stackroute.model.Address;
import com.stackroute.model.Book;
import com.stackroute.model.BorrowedBookInfo;
import com.stackroute.model.Member;
import com.stackroute.model.MemberAccount;

public class MemberService implements iMemberService{
	
	iLibraryRepository libraryrepo = new LibraryRepository();
	int i;
	public MemberService() {
		i=100;
	}

	@Override
	public int openAccount(String name, int doorNo, String street, String ctiy, String state, long pincode) {
		int id = i++; 
		int acctNo = 1000 + new Random().nextInt(9000);
		Address newadd = libraryrepo.addAddress(doorNo,street,ctiy,state,pincode);
		BorrowedBookInfo[] bbinfo = null;
		MemberAccount newAccount = libraryrepo.addMemberAccount(acctNo, bbinfo);
		Member newMember = libraryrepo.addMemeber(id, name, newadd, newAccount);
	    libraryrepo.openAccount(newAccount, newMember);
		int acc = newMember.getMemberAccount().getAccountNo();
		return acc;
	}
	
	@Override
	public BorrowedBookInfo[] borrowBooks(int accno,int bno,String sdate) {
		Book addbook = libraryrepo.findBook(bno);
		MemberAccount acct = libraryrepo.findAccount(accno);
		int taken = acct.getBorrowed().length;
		if (acct != null) {
			if (addbook != null) {
				if (taken < 5) {
					acct=libraryrepo.borrowBooks(acct,addbook,sdate);
				}
			}
		}
		BorrowedBookInfo[] result = acct.getBorrowed();
		return result;
	}

	@Override
	public BorrowedBookInfo[] returnBooks(int accno, int bno) {
		Book deletebook = libraryrepo.findBook(bno);
		MemberAccount acct = libraryrepo.findAccount(accno);
		if (acct != null) {
			if (deletebook != null) {
					acct=libraryrepo.returnBooks(acct,deletebook);
			}
		}
		BorrowedBookInfo[] result = acct.getBorrowed();
		return result;
	}

	@Override
	public MemberAccount getAccountDetails(int mano) {
		List<MemberAccount> List = new ArrayList<>();
		List = libraryrepo.getMemberAccounts();
		System.out.println(List.size());
		MemberAccount findacct = libraryrepo.findAccount(mano);
		return findacct;
	}

	@Override
	public long returnBookDue(int accno, int bno, String endDate) {
		Book duebook = libraryrepo.findBook(bno);
		MemberAccount acct = libraryrepo.findAccount(accno);
		long dueAmt = libraryrepo.findDueAmtonBook(acct,duebook,endDate);
		if(dueAmt < 0) {
			dueAmt = 0;
		}
		return dueAmt;
	}
	
	@Override
	public long getDueAmount(int accno) {
		long days = 0,dueAmt=0;
		MemberAccount acct = libraryrepo.findAccount(accno);
		BorrowedBookInfo[] borrowed = acct.getBorrowed();
		for (BorrowedBookInfo target : borrowed) {
			if(target.getDueDate().isBefore(LocalDate.now())) {
				 days = days + target.getDueDate().until(LocalDate.now(), ChronoUnit.DAYS);
			}
		}
		dueAmt = days * 100;
		return dueAmt;
	}

	@Override
	public void payDueAmount(int accno, long amt) {
		long dueAmt =  getDueAmount(accno);
		if(dueAmt == amt) {
			MemberAccount acct = libraryrepo.findAccount(accno);
			BorrowedBookInfo[] borrowed = acct.getBorrowed();
			List<BorrowedBookInfo> borrowedList = new ArrayList<>(Arrays.asList(borrowed));
			ListIterator<BorrowedBookInfo> lstiterator = borrowedList.listIterator();
			while (lstiterator.hasNext()) {
				BorrowedBookInfo obj = lstiterator.next();
					lstiterator.remove();
			}
			borrowed = new BorrowedBookInfo[borrowedList.size()];
			borrowed = borrowedList.toArray(borrowed);
			acct.setBorrowed(borrowed);
		}
	}
	
}
