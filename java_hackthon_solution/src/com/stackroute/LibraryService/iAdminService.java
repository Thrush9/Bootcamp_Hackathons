package com.stackroute.LibraryService;

public interface iAdminService {

	public void lendBooks(int mno, int bno, String start);
	
	public void collectDue();

	public long getDueAmount(int pno);

	public void payDueAmount(int pno, int amt);
	
}
