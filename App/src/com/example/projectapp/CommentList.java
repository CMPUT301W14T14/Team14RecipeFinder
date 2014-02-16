package com.example.projectapp;

import java.util.ArrayList;
import java.util.Comparator;


public class CommentList{
	//Sub Classes (just skeleton):
	class TimePostedComparator implements Comparator<Comment>{

		@Override
		public int compare(Comment lhs, Comment rhs)
		{

			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	class LocationComparator implements Comparator<Comment>{

		@Override
		public int compare(Comment lhs, Comment rhs)
		{

			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	class PictureComparator implements Comparator<Comment>{

		@Override
		public int compare(Comment lhs, Comment rhs)
		{

			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	//Attributes:
	ArrayList<Comment> comments=null;
	Comment parent=null;
	
	//Methods:
	
	//Constructors:
	public CommentList(){
		this.comments=new ArrayList<Comment>();
	}
	
	//Constructor with extra parameters:
	public CommentList(ArrayList<Comment> comments){
		this.comments=comments;
	}
	
	//Getters&Setters:
	
	//Parent Comment
	public void setParent(Comment parent){
		this.parent=parent;
	}
	
	public Comment getParent(){
		return this.parent;
	}
	
	//Operations:
	public void addReply(Comment reply){
		comments.add(reply);
	}
	
	//public Comment getOneComment(){
	//}
	
	
}
