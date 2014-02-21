package com.example.projectapp;

import java.util.ArrayList;
import java.util.Comparator;

import android.location.Location;


public class CommentList {
	//Attributes:
	private ArrayList<Comment> comments=null;
	private TimeComparator timeCmp=new TimeComparator();
	private PictureComparator picCmp=new PictureComparator();
	private LocationComparator locCmp=new LocationComparator();
	
	//Constructor:
	public CommentList(ArrayList<Comment> comments){
		this.comments=comments;
	}
	
	//Methods:
	public void addComment(Comment comment){
		this.comments.add(comment);
	}
	
	//Unimplemented Methods:
	public void getAdapterSortedByTime(){    //Need change!
		
	}
	
	public void getAdapterSortedByPicture(){    //Need change!
		
	}
	
	public void getAdapterSortedByLocation(Location location){    //Need change!
		
	}
	
	//Unimplemented SubClasses:
	private class TimeComparator implements Comparator<Comment>{

		@Override
		public int compare(Comment arg0, Comment arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	private class PictureComparator implements Comparator<Comment>{

		@Override
		public int compare(Comment lhs, Comment rhs) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	private class LocationComparator implements Comparator<Comment>{
        private Location center=null;
        
		@Override
		public int compare(Comment lhs, Comment rhs) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public void setCenterLocation(Location location){
			this.center=location;
		}
	}
}
