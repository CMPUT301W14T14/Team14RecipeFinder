package com.example.projectapp;

import java.util.HashMap;
import java.util.Map;


public class UserList{
	private Map<Long,User> users=null;
	private User currentUser=null;
	private Long nextId=null;
	
	public UserList(){
		this.users=new HashMap<Long,User>();
		this.nextId=(long) 0;
	}
	
	private User getUser(String userName){
		for(Map.Entry<Long,User> pair: this.users.entrySet()){
			User current=pair.getValue();
			if(current.getUserName().equals(userName)){
				return current;
			}
		}
		return null;
	}
	
	private String setCurrentUser(String userName, String password){
		User target=this.getUser(userName);
		if(target==null){
			return "NOT_EXIST";
		}
		else{
			if(target.getPassword().equals(password)){
				return "ACCESS";
			}
			else{
				return "REJECT";
			}
		}
	}

	private void addUser(String userName,String password){
        this.users.put(this.nextId,new User(this.nextId,userName,password));
        this.nextId++;
    }
	
	public boolean login(String userName,String password){
		String Tag=this.setCurrentUser(userName,password);
		if(Tag.equals("ACCESS")){
			return true;
		}
		else if(Tag.equals("REJECT")){
			return false;
		}
		else if(Tag.equals("NOT_EXIST")){
			this.addUser(userName,password);
			return true;
		}
		return false;
	}
	
	public User getCurrentUser(){
		return this.currentUser;
	}
	
	public Long getCurrentUserId(){
		return this.currentUser.getId();
	}
	
	public boolean changeUserName(Long id,String newUserName){
		User target=this.getUser(newUserName);
		if(target==null){
			users.get(id).setUserName(newUserName);
			return true;
		}
		return false;
	}
	
	public void changePassword(Long id,String newPassword){
		users.get(id).setPassword(newPassword);
	}
}
