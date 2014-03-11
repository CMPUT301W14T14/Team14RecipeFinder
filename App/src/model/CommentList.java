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
		int index=0;
		for(Comment c : this.comments){
			if(c.getId().equals(comment.getId())){
				this.comments.remove(index);
			}
			index++;
		}
		this.comments.add(comment);
	}
	
	public void clear(){
		this.comments.clear();
	}
	
	public List<Comment> getCurrentList(){
		return Collections.unmodifiableList(this.comments);
	}
}
