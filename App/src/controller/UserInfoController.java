package controller;

import model.User;

public class UserInfoController {
	private User currentUser=null;
	
	public UserInfoController(){}
	
	public void setUser(User user){
		this.currentUser=user;
	}
	
	public User getUser(){
		return this.currentUser;
	}
}
