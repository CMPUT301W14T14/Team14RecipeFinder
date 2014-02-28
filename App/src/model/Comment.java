package model;

import java.util.ArrayList;
import java.util.Date;


import android.graphics.Bitmap;
import android.location.Location;

public class Comment {
	//Attributes:
	private String text=null;
	private Location location=null;
	private Bitmap picture=null;
	private Long timePosted=null;
	private String userName=null;
	private ChildCommentList childReply=null;
	
	//Constructors:
	public Comment(String text,Location location,String userName){
		this.text=text;
		this.location=location;
		this.timePosted=(new Date()).getTime();
		this.userName=userName;
		this.childReply=new ChildCommentList(new ArrayList<Comment>());
		this.childReply.setParent(this);
	}
	
	public Comment(String text,Location location,Bitmap picture,String userName){
		this.text=text;
		this.location=location;
		this.picture=picture;
		this.timePosted=(new Date()).getTime();
		this.userName=userName;
		this.childReply=new ChildCommentList(new ArrayList<Comment>());
		this.childReply.setParent(this);
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
	public String getUserName(){
		return this.userName;
	}
	
	//For children
	public ChildCommentList getReplies(){
		return this.childReply;
	}
	
	public void setReplies(ChildCommentList childReply){
		this.childReply=childReply;
	}
	
	//Methods:
	
	//Unimplemented Methods:
	public void addReply(){
		
	}
}