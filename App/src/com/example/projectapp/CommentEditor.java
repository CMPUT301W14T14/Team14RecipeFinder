package com.example.projectapp;

import android.location.Location;


public class CommentEditor{
	private Comment comment=null;
	
	public CommentEditor(Comment comment){
		this.comment=comment;
	}
	
	public Comment Edit(String text){
		this.comment.setText(text);
		return this.comment;
	}
	
	public Comment Edit(Location location){
		this.comment.setLocation(location);
		return this.comment;
	}
}
