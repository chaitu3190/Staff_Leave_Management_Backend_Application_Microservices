package com.example.demo.dto;

public class Login_Credentials {
	String name;
	String password;
	public Login_Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login_Credentials(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
