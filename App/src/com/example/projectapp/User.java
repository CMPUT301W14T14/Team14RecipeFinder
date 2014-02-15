package com.example.projectapp;


public class User{
	private Long id=null;
	private String userName=null;
	
	public User(Long id,String userName){
		this.id=id;
		this.userName=userName;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserName(){
		return this.userName;
	}
}
