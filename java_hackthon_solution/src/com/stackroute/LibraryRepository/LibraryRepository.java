package com.stackroute.LibraryRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import com.stackroute.model.Address;
import com.stackroute.model.Book;
import com.stackroute.model.BorrowedBookInfo;
import com.stackroute.model.Library;
import com.stackroute.model.Member;
import com.stackroute.model.MemberAccount;


public class LibraryRepository implements iLibraryRepository {
	
	Book b1, b2, b3;
	Book[] list;
	Address add1, add2;
	Library l1;
	BorrowedBookInfo bb1,bb2;
	MemberAccount acct1;
	Member user1;
	List<Book> bookList = new ArrayList<>();
    List<Member> memList = new ArrayList<>();
    List<MemberAccount> memAccList = new ArrayList<>();
    BorrowedBookInfo[] bblist = new BorrowedBookInfo[5];
    
	public LibraryRepository() {
		
		b1 = new Book(51, "Maths", "SS Publishers");
		b2 = new Book(25, "Physics", "SG Publishers");
		b3 = new Book(81, "Chemistry", "CRF Publishers");
		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		add1 = new Address(23, "Adam St", "LA", "USA", 879567);
		add2 = new Address(9, "Church St", "NM", "Mexico", 555567);
		l1 = new Library("Johnlabs", add1, "01AB", list);
		bb1 = new BorrowedBookInfo(b1, LocalDate.of(2020, 10, 01), LocalDate.of(2020, 10, 30));
		bb2 = new BorrowedBookInfo(b2, LocalDate.of(2020, 10, 01), LocalDate.of(2020, 10, 30));
		BorrowedBookInfo[]	bblist ={ bb1,bb2 };
		acct1 = new MemberAccount(1048, bblist);
		memAccList.add(acct1);
		user1 = new Member(50, "Thrush", add2, acct1);
		memList.add(user1);
	}

	@Override
	public List<Book> getBooks() {
		return bookList;
	}
	
	@Override
	public List<MemberAccount> getMemberAccounts() {
		return memAccList;
	}

	@Override
	public List<Member> getMembers() {
		return memList;
	}
	
	@Override
	public Address addAddress(int addNo, String addst, String addctiy, String addstate, long addpin) {
		Address memAddress = new Address(addNo, addst, addctiy, addstate, addpin);
		return memAddress;
	}

	@Override
	public BorrowedBookInfo addBBInfo(Book book, String startDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = start.plusDays(60);
		BorrowedBookInfo newbb = new BorrowedBookInfo(book,start,end);
		return newbb;
	}

	@Override
	public MemberAccount addMemberAccount(int accno, BorrowedBookInfo[] list) {
		MemberAccount newMemAcc = new MemberAccount(accno,list);
		return newMemAcc;
	}

	@Override
	public Member addMemeber(int id, String name, Address addr, MemberAccount account) {
		Member newMem = new Member(id,name,addr,account);
		return newMem;
	}
	
	@Override
	public void openAccount(MemberAccount newAccount,Member newMember) {
		memAccList.add(newAccount);
		memList.add(newMember);
	}

	@Override
	public MemberAccount findAccount(int accno) {
		MemberAccount findAcct = null;
		for (MemberAccount list : memAccList) {
			if(list.getAccountNo() == accno) {
				findAcct = list;
			}
		}
		return findAcct;
	}
	
	@Override
	public Book findBook(int bookno) {
		Book findBook = null;
		for (Book list : bookList) {
			if(list.getBnNo() == bookno) {
				findBook = list;
			}
		}
		return findBook;
	}
	
	@Override
	public void lendBooks() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectDue() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public MemberAccount borrowBooks(MemberAccount acct, Book addbook, String sdate) {
		BorrowedBookInfo[] borrowed = acct.getBorrowed();
		BorrowedBookInfo newbb = addBBInfo(addbook, sdate);
		List<BorrowedBookInfo> borrowedList = new ArrayList<>(Arrays.asList(borrowed));
		borrowedList.add(newbb);
		borrowed = borrowedList.toArray(borrowed);
		acct.setBorrowed(borrowed);
        return acct;
	}

	@Override
	public MemberAccount returnBooks(MemberAccount acct, Book deletebook) {
		BorrowedBookInfo[] borrowed = acct.getBorrowed();
		List<BorrowedBookInfo> borrowedList = new ArrayList<>(Arrays.asList(borrowed));
		ListIterator<BorrowedBookInfo> lstiterator = borrowedList.listIterator();
		while (lstiterator.hasNext()) {
			BorrowedBookInfo obj = lstiterator.next();
			if (obj.getBook().getBnNo()==deletebook.getBnNo()) {
				lstiterator.remove();
			}
		}
		borrowed = new BorrowedBookInfo[borrowedList.size()];
		borrowed = borrowedList.toArray(borrowed);
		acct.setBorrowed(borrowed);
        return acct;
	}

	@Override
	public long findDueAmtonBook(MemberAccount acct, Book duebook, String endDate) {
		long daysBetween = 0,dueAmt;
		LocalDate end = LocalDate.parse(endDate);
		BorrowedBookInfo[] borrowed = acct.getBorrowed();
		for (BorrowedBookInfo target : borrowed) {
			if(target.getBook().equals(duebook)) {
				 daysBetween = target.getDueDate().until(end, ChronoUnit.DAYS);
			}
		}
		dueAmt = daysBetween * 100; 
		return dueAmt;
	}
	
	@Override
	public void payDues() {
		// TODO Auto-generated method stub

	}

}
