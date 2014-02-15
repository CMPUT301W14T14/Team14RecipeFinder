package com.example.projectapp;

import java.util.Date;

import android.graphics.Bitmap;
import android.location.Location;


public class Comment{
	//Attributes
	private String text=null;
	private Long timePosted=null;
	private Bitmap picture=null;
	private Location location=null;
	private Long userId=null;
	private CommentList childReply=null;
	
	//Methods:
	
	//Constructors:
	public Comment(String text,Long userId){
		this.text=text;
		this.userId=userId;
		this.timePosted=(new Date()).getTime();
		//this.location=getCurrentLocation;
		this.childReply=new CommentList();
		this.childReply.setParent(this);
	}
	
	public Comment(String text,Long userId,Bitmap picture){
		this.text=text;
		this.userId=userId;
		this.timePosted=(new Date()).getTime();
		//this.location=getCurrentLocation;
		this.picture=picture;
		this.childReply=new CommentList();
		this.childReply.setParent(this);
	}
	
	//Constructor with extra parameters:
	public Comment(String text,Long userId,CommentList childReply){
		this.text=text;
		this.userId=userId;
		this.timePosted=(new Date()).getTime();
		//this.location=getCurrentLocation;
		this.childReply=childReply;
		this.childReply.setParent(this);
	}
	
	public Comment(String text,Long userId,Bitmap picture,CommentList childReply){
		this.text=text;
		this.userId=userId;
		this.timePosted=(new Date()).getTime();
		//this.location=getCurrentLocation;
		this.picture=picture;
		this.childReply=childReply;
		this.childReply.setParent(this);
	}
	
	//Setters&Getters:
	
	//For text
	public void setText(String newText){
		this.text=newText;
	}
	
	public String getText(){
		return this.text;
	}
	
	//For picture
	public Bitmap getPicture(){
		return this.picture;
	}
	
	//For time posted
	public Long getTimePosted(){
		return this.timePosted;
	}
	
	//For Location
	public void setLocation(Location newLocation){
		this.location=newLocation;
	}
	
	public Location getLocation(){
		return this.location;
	}
	
	//Operations:
	
	public void addReply(Comment newReply){
		this.childReply.addReply(newReply);
	}
	
	public boolean checkUserId(Long userId){
		if(this.userId==userId){
			return true;
		}
		else{
			return false;
		}
	}
}
