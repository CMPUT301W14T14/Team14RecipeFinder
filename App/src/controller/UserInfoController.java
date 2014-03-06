package controller;

import model.User;

/**
 * a controller used with UserInfoHandler to get user object from the server
 */

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
