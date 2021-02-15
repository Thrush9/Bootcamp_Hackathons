package com.stackroute.model;

public class Address {

	private int doorNo;
	private String streetName;
	private String city;
	private String state;
	private long pinCode;

	public Address(int no, String name, String city, String state, long code) {
		this.doorNo = no;
		this.streetName = name;
		this.city = city;
		this.state = state;
		this.pinCode = code;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", streetName=" + streetName + ", city=" + city + ", state=" + state
				+ ", pinCode=" + pinCode + "]";
	}

}
