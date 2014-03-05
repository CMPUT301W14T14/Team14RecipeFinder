package model;

import java.util.ArrayList;



public class User {
	//Attributes:
	private String id=null;
	private String userName=null;
	private ArrayList<String> favourite_comment_ids=null;
	private ArrayList<String> indicated_comment_ids=null;
	
	//Constructors
	public User(String id,String userName){
		this.id=id;
		this.userName=userName;
		this.favourite_comment_ids=new ArrayList<String>();
		this.indicated_comment_ids=new ArrayList<String>();
	}
	
	//Getters&&Setters
	public String getId(){
		return this.id;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public ArrayList<String> getFavourites(){
		return this.favourite_comment_ids;
	}
	
	public ArrayList<String> getIndicatedComments(){
		return this.indicated_comment_ids;
	}
	
	//Methods:
	public void addFav(Comment comment){
		this.favourite_comment_ids.add(comment.getId());
	}
	
	public void addFav(String commentId){
		this.favourite_comment_ids.add(commentId);
	}
	
	public void addIndicated(Comment comment){
		this.indicated_comment_ids.add(comment.getId());
	}
	
	public void addIndicated(String commentId){
		this.indicated_comment_ids.add(commentId);
	}
}
