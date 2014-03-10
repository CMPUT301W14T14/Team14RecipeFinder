/**
 * 
 */
package com.example.projectapp.test;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import activity.PublishActivity;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import model.Comment;

/**
 * @author Yilu
 *
 */
public class CommentTest extends TestCase {

	public CommentTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Test getId method
	 */
	public void testGetId() {
		Comment comment = new Comment("title","text", null,"userName");
		assertEquals(comment.getId(), "userName"+(new Date()).getTime());
	}
	
	/**
	 * Test getTitle method
	 */
	public void testGetTitle(){
		Comment comment = new Comment("title","text", null,"userName");
		assertEquals(comment.getTitle(), "title");
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
}


