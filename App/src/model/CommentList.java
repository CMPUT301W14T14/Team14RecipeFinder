package model;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public void setComment(Comment before,Comment after){
		this.comments.set(this.comments.indexOf(before),after);
	}
	
	//Unimplemented Methods:
	public Comment[] getArraySortedByTime(){    //Need change!
		Collections.sort(this.comments,this.timeCmp);
		return (Comment[]) this.comments.toArray();
	}
	
	public Comment[] getArraySortedByPicture(){    //Need change!
		Collections.sort(this.comments,this.picCmp);
		return (Comment[]) this.comments.toArray();
	}
	
	public Comment[] getArraySortedByLocation(Location location){    //Need change!
		this.locCmp.setCenterLocation(location);
		Collections.sort(this.comments,this.locCmp);
		return (Comment[]) this.comments.toArray();
	}
	
	//Method uses for testing temperately:
	public Comment[] getRandomArray(){
		return (Comment[]) this.comments.toArray();
	}
	
	//Comparators:
	
	private class TimeComparator implements Comparator<Comment>{

		@Override
		public int compare(Comment a,Comment b){
			if(a.getTimePosted()>=b.getTimePosted()){
				return -1;
			}
			else{
				return 1;
			}
		}
		
	}
	
	private class PictureComparator implements Comparator<Comment>{

		@Override
		public int compare(Comment a,Comment b){
			if((a.getPicture()!=null)&&(b.getPicture()==null)){
				return -1;
			}
			else if((a.getPicture()==null)&&(b.getPicture()!=null)){
				return 1;
			}
			return 0;
		}
		
	}
	
	
	//implemented SubClasses:
	private class LocationComparator implements Comparator<Comment>{
        private Location center=null;
        
		@Override
		public int compare(Comment a,Comment b){
			if(a.getLocation().distanceTo(this.center)<=b.getLocation().distanceTo(center)){
				return -1;
			}
			else{
				return 1;
			}
		}
		
		public void setCenterLocation(Location location){
			this.center=location;
		}
	}
}
