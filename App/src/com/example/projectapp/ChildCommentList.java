package com.example.projectapp;

import java.util.ArrayList;



public class ChildCommentList extends CommentList{
	
	//Attributes:
	private Comment parent=null;

	public ChildCommentList(ArrayList<Comment> comments) {
		super(comments);
	}
	
	public Comment getParent(){
		return this.parent;
	}
	
	public void setParent(Comment comment){
		this.parent=comment;
	}
}
