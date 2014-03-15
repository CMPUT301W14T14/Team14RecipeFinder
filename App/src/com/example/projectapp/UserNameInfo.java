package com.example.projectapp;

import android.app.Application;

/**
 * A class can let the userName String be set/get from any acitivity from this application
 * @author xuping
 *
 */
public class UserNameInfo extends Application{
	
	private String userName=null;
	/**
	 * 
	 * @return the current userName
	 */
	public String getUserName(){
		return this.userName;
	}
	/**
	 * set the userName
	 * @param userName
	 */
	public void setUserName(String userName){
		this.userName=userName;
	}
}
