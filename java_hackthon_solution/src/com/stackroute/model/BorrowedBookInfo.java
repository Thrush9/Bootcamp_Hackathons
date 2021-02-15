package com.stackroute.model;

import java.time.LocalDate;

public class BorrowedBookInfo {
	
	private Book book;
	private LocalDate borrowedDate;
	private LocalDate dueDate;
	
	public BorrowedBookInfo(Book book,LocalDate startDate,LocalDate endDate) {
		this.book = book;
		this.borrowedDate = startDate;
		this.dueDate = endDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(LocalDate borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "BorrowedBookInfo [book=" + book + ", borrowedDate=" + borrowedDate + ", dueDate=" + dueDate + "]";
	}

}
