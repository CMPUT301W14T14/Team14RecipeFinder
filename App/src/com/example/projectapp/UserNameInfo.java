package com.example.projectapp;

import android.app.Application;


public class UserNameInfo extends Application{
	
	private String userName=null;
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
}
