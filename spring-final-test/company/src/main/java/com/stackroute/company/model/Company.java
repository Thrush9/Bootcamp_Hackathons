package com.stackroute.company.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
	
	@Id
	private int id;
	private String companyname;
	private String location;
	
	public Company() {}
	
	public Company(int id,String name,String loc) {
		this.id = id;
		this.companyname = name;
		this.location = loc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyname=" + companyname + ", location=" + location + "]";
	}
	
	

}
