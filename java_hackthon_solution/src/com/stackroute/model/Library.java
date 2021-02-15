package com.stackroute.model;

import java.util.Arrays;

public class Library {
	
	private String libraryName;
	private Address address; // the address of the library
	private String registerNumber;
	private Book[] books;// A library has books


	public Library(String name,Address addr,String reg,Book[] bs) {
		this.libraryName = name;
		this.address = addr;
		this.registerNumber = reg;
		this.books = bs;
	}


	public String getLibraryName() {
		return libraryName;
	}


	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getRegisterNumber() {
		return registerNumber;
	}


	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}


	public Book[] getBooks() {
		return books;
	}


	public void setBooks(Book[] books) {
		this.books = books;
	}


	@Override
	public String toString() {
		return "Library [libraryName=" + libraryName + ", address=" + address + ", registerNumber=" + registerNumber
				+ ", books=" + Arrays.toString(books) + "]";
	}
	
}
