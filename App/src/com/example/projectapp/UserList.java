package com.example.projectapp;

import java.util.HashMap;
import java.util.Map;


public class UserList{
	private Map<Long,User> users=null;
	private User currentUser=null;
	private Long nextId=null;
	
	public UserList(){
		this.users=new HashMap<Long,User>();
		this.nextId=(long)0;
	}
	
	private User _get_user_(String userName){
		User current=null;
		for(Map.Entry<Long,User> pair: users.entrySet()){
			current=pair.getValue();
			if(current.getUserName().equals(userName)){
				return current;
			}
		}
		return null;
	}
	
	private String _set_current_user_(String userName){
		User target=this._get_user_(userName);
		if(target==null){
			User newUser=new User(this.nextId,userName);
			this.users.put(this.nextId,newUser);
			this.currentUser=newUser;
			this.nextId++;
			return "CREATE";
		}
		else{
			this.currentUser=target;
			return "ACCESS";
		}
	}
	
	public String login(String userName){
		String tag=this._set_current_user_(userName);
		return tag;
	}
	
	public Long getCurrentUserId(){
		return this.currentUser.getId();
	}
	
	public User getUser(Long id){
		return this.users.get(id);
	}
	
	public boolean changeUserName(Long id,String userName){
		if(this._get_user_(userName)==null){
			this.users.get(id).setUserName(userName);
			return true;
		}
		return false; // note: it may be the same name as before in this case.
	}

}
