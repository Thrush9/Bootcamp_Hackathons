package com.stackroute.LibraryService;

import com.stackroute.model.BorrowedBookInfo;

public class AdminService implements iAdminService{
	
	MemberService memberService = new MemberService();

	@Override
	public void lendBooks(int mno, int bno, String start) {
		BorrowedBookInfo[] lendbooks = memberService.borrowBooks(mno,bno,start);
	}

	@Override
	public void collectDue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getDueAmount(int pno) {
		long amt = memberService.getDueAmount(pno);
		return amt;
	}

	@Override
	public void payDueAmount(int pno, int amt) {
		memberService.payDueAmount(pno, amt);	
	}

}
