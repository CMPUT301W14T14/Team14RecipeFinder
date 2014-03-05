package model;

import java.util.HashMap;
import java.util.Map;

public class UserMap{
	private Map<String,User> users=null;
	private Integer nextId=null;
	private HashMap<String, String> inverted=null;
	
	public UserMap(){
		this.users=new HashMap<String,User>();
		this.inverted=new HashMap<String,String>();
		this.nextId=0;
	}
	
	public boolean addANewUser(String userName){
		if(this.inverted.containsKey(userName)){
			return false;
		}
		User newUser=new User(this.nextId+"",userName);
		this.users.put(this.nextId+"",newUser);
		this.inverted.put(userName,this.nextId+"");
		this.nextId++;
		return true;
	}
	
	public String getUserName(String userId){
		return this.users.get(userId).getUserName();
	}
	
	public User getUser(String userName){
		return this.users.get(this.inverted.get(userName));
	}
	
	public boolean contains(String userName){
		return this.inverted.containsKey(userName);
	}
	
	public boolean update(String userId,User updatedUser){
		if((updatedUser.getId().equals(userId))==false || (this.users.containsKey(userId)==false)){
			return false;
		}
		boolean a=this.inverted.containsKey(updatedUser.getUserName());
		boolean b=this.inverted.get(updatedUser.getUserName()).equals(userId);
		if(a==true && b==false){
			return false;
		}
		String oldUserName=this.users.get(userId).getUserName();
		this.inverted.remove(oldUserName);
		this.inverted.put(updatedUser.getUserName(),userId);
		this.users.put(userId, updatedUser);
		return true;
	}
}
