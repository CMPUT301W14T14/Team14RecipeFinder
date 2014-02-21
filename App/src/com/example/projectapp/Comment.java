package com.example.projectapp;

import java.util.Date;

import android.graphics.Bitmap;
import android.location.Location;

public class Comment {
	//Attributes:
	private String text=null;
	private Location location=null;
	private Bitmap picture=null;
	private Long timePosted=null;
	private Long userId=null;
	private ChildCommentList childReply=null;
	
	//Constructors:
	public Comment(String text,Location location,Long userId){
		this.text=text;
		this.location=location;
		this.timePosted=(new Date()).getTime();
		this.userId=userId;
	}
	
	public Comment(String text,Location location,Bitmap picture,Long userId){
		this.text=text;
		this.location=location;
		this.picture=picture;
		this.timePosted=(new Date()).getTime();
		this.userId=userId;
	}
	
	//Getters&&Setters:
	//For Text
	public String getText(){
		return this.text;
	}
	
	public void setText(String newText){
		this.text=newText;
	}
	
	//For Location
	public Location getLocation(){
		return this.location;
	}
	
	public void setLocation(Location newLocation){
		this.location=newLocation;
	}
	
	//For picture
	public Bitmap getPicture(){
		return this.picture;
	}
	
	//For timePosted
	public Long getTimePosted(){
		return this.timePosted;
	}
	//For userId
	public Long getUserId(){
		return this.userId;
	}
	
	//For children
	public ChildCommentList getReplies(){
		return this.childReply;
	}
	
	//Methods:
	
	//Unimplemented Methods:
	public void addReply(){
		
	}
}
