package com.stackroute.model;

public class Member {
	
	 private int memberId;
	 private String name;
	 private Address address; // the address of a member
	 private MemberAccount memberAccount; // A member has an account


	 public Member(int id,String name,Address addr,MemberAccount account) {
		 this.memberId = id;
		 this.name = name;
		 this.address = addr;
		 this.memberAccount = account;
	 }


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public MemberAccount getMemberAccount() {
		return memberAccount;
	}


	public void setMemberAccount(MemberAccount memberAccount) {
		this.memberAccount = memberAccount;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", address=" + address + ", memberAccount="
				+ memberAccount + "]";
	}
	 
}
