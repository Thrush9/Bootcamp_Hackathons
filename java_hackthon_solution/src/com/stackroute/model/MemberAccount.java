package com.stackroute.model;

import java.util.Arrays;

public class MemberAccount {
	
	private int accountNo;
    private BorrowedBookInfo[] borrowed;
    // a member can borrow 5 books at a time thus the array /// to store information
    
    public MemberAccount(int no,BorrowedBookInfo[] list ) {
    	this.accountNo = no;
    	this.borrowed = list;
    }

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public BorrowedBookInfo[] getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(BorrowedBookInfo[] borrowed) {
		this.borrowed = borrowed;
	}

	@Override
	public String toString() {
		return "MemberAccount [accountNo=" + accountNo + ", borrowed=" + Arrays.toString(borrowed) + "]";
	}

}
