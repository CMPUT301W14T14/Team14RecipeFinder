package model;

import java.util.ArrayList;
import java.util.Date;


import android.graphics.Bitmap;
import android.location.Location;

public class Comment {
	//Attributes:
	private String id=null;
	private String text=null;
	private Location location=null;
	private Bitmap picture=null;
	private Long timePosted=null;
	private String userId=null;
	private String parentId=null;
	private ArrayList<String> replyIdSet=null;
	
	//Constructors:
	public Comment(String text,Location location,String userId){
		this.text=text;
		this.location=location;
		this.timePosted=(new Date()).getTime();
		this.userId=userId;
		this.id=this.userId+this.timePosted;
		this.replyIdSet=new ArrayList<String>();
	}
	
	public Comment(String text,Location location,Bitmap picture,String userId){
		this.text=text;
		this.location=location;
		this.picture=picture;
		this.timePosted=(new Date()).getTime();
		this.userId=userId;
		this.id=this.userId+this.timePosted;
		this.replyIdSet=new ArrayList<String>();
	}
	
	//Getters&&Setters:
	//ForId
	public String getId(){
		return this.id;
	}
	
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
	public String getUserId(){
		return this.userId;
	}
	
	//For children
	public ArrayList<String> getReplies(){
		return this.replyIdSet;
	}
	
	//For parentId
	public String getParentId(){
		return this.parentId;
	}
	
	public void setParent(Comment parent){
		this.parentId=parent.getId();
	}
	
	public void setParent(String parentId){
		this.parentId=parentId;
	}
	
	//Methods:
	
	public void addReply(Comment comment){
		this.replyIdSet.add(comment.getId());
	}
	
	public void addReply(String replyId){
		this.replyIdSet.add(replyId);
	}
}
