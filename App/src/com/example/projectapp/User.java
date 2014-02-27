package com.example.projectapp;


public class User {
	//Attributes:
	private String userName=null;
	private CommentList favourites=null;
	private CommentList indcatedComments=null;
	
	//Constructors
	public User(String userName){
		this.userName=userName;
	}
	
	//Getters&&Setters
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public CommentList getFavourites(){
		return this.favourites;
	}
	
	public CommentList getIndicatedComments(){
		return this.indcatedComments;
	}
	
	//Methods:
	public void addFavourite(Comment comment){
		this.favourites.addComment(comment);
	}
	
	public void addIndicatedComment(Comment comment){
		this.indcatedComments.addComment(comment);
	}
}
