package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommentMap{
	private Map<String,Comment> comments=null;
	
	/**
	 * construct a commentMap object 
	 */
	
	public CommentMap(){
		this.comments=new HashMap<String,Comment>();
	}
	
	/**
	 * update a comment in the comment map with its own id, if the comment is not exist, then added it to the map
	 */
	public void updateComment(Comment comment){
		this.comments.put(comment.getId(),comment);
	}
	
	/**
	 * get a specific comment with its own id from the map
	 */
	
	public Comment getComment(String id){
		return this.comments.get(id);
	}
	
	/**
	 * get a list of comment in this map
	 */
	
	public List<Comment> getCurrentList(){
		List<Comment> list= new ArrayList<Comment>(this.comments.values());
		return Collections.unmodifiableList(list);
	}
}
