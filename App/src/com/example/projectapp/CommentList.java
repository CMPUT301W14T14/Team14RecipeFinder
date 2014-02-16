package com.example.projectapp;

import java.util.ArrayList;
import java.util.Comparator;

import android.location.Location;


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
    
	//unimplemented Test Methods, all with incorrect return statement
	public ArrayList<Comment> getSortedArrayListByProximityForTesting(Location location){

		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Comment> getArrayListForTesting()
	{

		// TODO Auto-generated method stub
		return null;
	}
    //unimplemented Methods
	public Object getListViewAdapterSortedByTimePosted()
	{

		// TODO Auto-generated method stub
		return null;
	}

	public Comment getSpecificComment()
	{

		// TODO Auto-generated method stub
		return null;
	}
}
