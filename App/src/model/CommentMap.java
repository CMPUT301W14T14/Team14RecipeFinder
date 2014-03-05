package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommentMap{
	private Map<String,Comment> comments=null;
	
	public CommentMap(){
		this.comments=new HashMap<String,Comment>();
	}
	
	public void updateComment(Comment comment){
		this.comments.put(comment.getId(),comment);
	}
	
	public Comment getComment(String id){
		return this.comments.get(id);
	}
	
	public List<Comment> getCurrentList(){
		List<Comment> list= new ArrayList<Comment>(this.comments.values());
		return Collections.unmodifiableList(list);
	}
}
