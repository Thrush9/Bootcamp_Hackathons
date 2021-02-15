package com.stackroute.model;

public class Book {
	
	private int bnNo;
	private String author;
	private String publisher;
	
	public Book(int no,String author,String publisher){
		this.bnNo = no;
		this.author =author;
		this.publisher = publisher;
	}

	public int getBnNo() {
		return bnNo;
	}

	public void setBnNo(int bnNo) {
		this.bnNo = bnNo;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bnNo=" + bnNo + ", author=" + author + ", publisher=" + publisher + "]";
	}

    
}
