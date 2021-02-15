package com.stackroute.LibraryService;

import com.stackroute.model.BorrowedBookInfo;
import com.stackroute.model.MemberAccount;

public interface iMemberService {
	
	public int openAccount(String name, int doorNo, String street, String ctiy, String state, long pincode);
	
	public BorrowedBookInfo[] borrowBooks(int accno,int bno,String sdate);
	
	public BorrowedBookInfo[] returnBooks(int accno, int bno);
	
	public MemberAccount getAccountDetails(int mano);

	public long returnBookDue(int accno, int bno, String endDate);

	public long getDueAmount(int accno);
	
	public void payDueAmount(int accno,long amt);
}
