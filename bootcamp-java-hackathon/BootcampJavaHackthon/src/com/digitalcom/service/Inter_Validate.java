package com.digitalcom.service;

public interface Inter_Validate {

	public boolean IsAuthenticated(String userid,String password,String usertype);

	public void addUser(String name, String password, String type);
}
