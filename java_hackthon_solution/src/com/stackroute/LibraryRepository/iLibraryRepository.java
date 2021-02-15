package com.stackroute.LibraryRepository;

import java.time.LocalDate;
import java.util.List;

import com.stackroute.model.Address;
import com.stackroute.model.Book;
import com.stackroute.model.BorrowedBookInfo;
import com.stackroute.model.Member;
import com.stackroute.model.MemberAccount;

public interface iLibraryRepository {

    public Address addAddress(int addNo, String addst, String addctiy, String addstate, long addpin);
	
	public BorrowedBookInfo addBBInfo(Book book,String startDate);
	
	public MemberAccount addMemberAccount(int accno,BorrowedBookInfo[] list);
	
	public Member addMemeber(int id,String name,Address addr,MemberAccount account);

	public List <Book> getBooks();
	
	public List<MemberAccount> getMemberAccounts();
	
	public List<Member> getMembers();
	
	public void openAccount(MemberAccount newAccount,Member newMember);
	
	public MemberAccount findAccount(int accno);
	
	public Book findBook(int bookno);
	
	public void lendBooks();
	
	public void collectDue();
	
	public MemberAccount borrowBooks(MemberAccount acct, Book addbook, String sdate);
	
	public MemberAccount returnBooks(MemberAccount acct, Book deletebook);
	
	public long findDueAmtonBook(MemberAccount acct, Book duebook, String endDate);

	public void payDues();
}
