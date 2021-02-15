package com.digitalcom.model;

public class User {

	private String userId;
	private String password;
	private String userType;

	public User(String username, String password, String type) {
		if (type.equals("user")) {
			this.userId = username;
			this.password = password;
			this.userType = type;
		} else if (type.equals("admin")) {
			this.userId = username;
			this.password = "password";
			this.userType = type;
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", userType=" + userType + "]";
	}

}
