package model;

import java.util.ArrayList;
import java.util.Date;


import android.graphics.Bitmap;
import android.location.Location;

/**
 * A Comment object which contains the title,id,text,location,a picture may attached,time posted ,a userName which published this comment,
 * and all of it's reply's comment id.
 * @author xuping
 *
 */
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
	 * Construct a Comment object without an attached picture
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
	 * Construct a Comment object with an attached picture
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
	 * Add the comment id of a reply Comment object to the reply id set.
	 */
	
	public void addReply(Comment comment){
		this.replyIdSet.add(comment.getId());
	}
	/**
	 * Add the comment id of a reply Comment object to the reply id set.
	 */
	
	public void addReply(String replyId){
		this.replyIdSet.add(replyId);
	}
	
	/**
	 * override the equals method in order to make a Comment with the same id equals each other
	 */
	@Override
	public boolean equals(Object o){
		if(this.id.equals(((Comment)o).getId())){
			return true;
		}
		return false;
	}
	
	
}
