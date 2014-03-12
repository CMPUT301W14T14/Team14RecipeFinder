package model;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;



public class CommentList{
	
	private ArrayList<Comment> comments=null;
	
	public CommentList(){
		comments=new ArrayList<Comment>();
	}
	
	public void add(Comment comment){
		this.comments.remove(comment);
		this.comments.add(comment);
	}
	
	public void clear(){
		this.comments.clear();
	}
	
	public List<Comment> getCurrentList(){
		return Collections.unmodifiableList(this.comments);
	}
}
