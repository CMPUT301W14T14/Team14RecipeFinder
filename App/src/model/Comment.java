package model;

import java.util.ArrayList;
import java.util.Date;


import android.graphics.Bitmap;
import android.location.Location;

public class Comment {
	//Attributes:
	private String title=null;
	private String id=null;
	private String text=null;
	private Location location=null;
	private Bitmap picture=null;
	private Long timePosted=null;
	private String userName=null;
	private String parentId=null;
	private ArrayList<String> replyIdSet=null;
	
	//Constructors:
	/**
	 * construct a comment object without an attached picture
	 */
	public Comment(String title,String text,Location location,String userName){
		this.title=title;
		this.text=text;
		this.location=location;
		this.timePosted=(new Date()).getTime();
		this.userName=userName;
		this.id=this.userName+this.timePosted;
		this.replyIdSet=new ArrayList<String>();
	}
	/**
	 * construct a comment object with an attached picture
	 */
	
	public Comment(String title,String text,Location location,Bitmap picture,String userName){
		this.title=title;
		this.text=text;
		this.location=location;
		this.picture=picture;
		this.timePosted=(new Date()).getTime();
		this.userName=userName;
		this.id=this.userName+this.timePosted;
		this.replyIdSet=new ArrayList<String>();
	}
	
	//Getters&&Setters:
	//ForId
	public String getId(){
		return this.id;
	}
	
	//For Title
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String newTitle){
		this.title=newTitle;
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
	//For userName
	public String getUserName(){
		return this.userName;
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
	/**
	 * add a comment id of the reply comment to the reply id set.
	 */
	
	public void addReply(Comment comment){
		this.replyIdSet.add(comment.getId());
	}
	/**
	 * add a comment id of the reply comment to the reply id set.
	 */
	
	public void addReply(String replyId){
		this.replyIdSet.add(replyId);
	}
	
	@Override
	public boolean equals(Object o){
		if(this.id.equals(((Comment)o).getId())){
			return true;
		}
		return false;
	}
	
	
}
