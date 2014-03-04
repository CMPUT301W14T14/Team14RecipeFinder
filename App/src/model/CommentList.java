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
		comment.setParentList(this);
		this.comments.add(comment);
	}
	
	public void updateComment(Comment updatedComment){
		int index=0;
		for(Comment c : this.comments){
			if((c.getUserId().equals(updatedComment.getUserId()))&&(c.getTimePosted().equals(updatedComment.getTimePosted()))){
				this.comments.set(index, updatedComment);
				return;
			}
			index++;
		}
	}
	
	public Comment getSpecfic(Long userId,Long timePosted){
		for(Comment c : this.comments){
			if((c.getUserId().equals(userId))&&(c.getTimePosted().equals(timePosted))){
				return c;
			}
		}
		return null;
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
