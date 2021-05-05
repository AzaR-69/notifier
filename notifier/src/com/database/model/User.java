package com.database.model;

public class User {
	private String userName;
	private String phoneNumber;
	private String email;
	private String password;
	public User() {}
	public User(String userName, String phoneNumber, String email, String password) {
		super();
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
