package com.example.projectapp;


public class User{
	private Long id=null;
	private String userName=null;
	private String password=null;
	
	public User(Long id,String userName, String password){
		this.id=id;
		this.userName=userName;
		this.password=password;
	}
	
	public Long getId(){
		return this.id;
	}

	
	public String getUserName()
	{
	
		return userName;
	}

	
	public void setUserName(String userName)
	{
	
		this.userName = userName;
	}

	
	public String getPassword()
	{
	
		return password;
	}

	
	public void setPassword(String password)
	{
	
		this.password = password;
	}	
}
