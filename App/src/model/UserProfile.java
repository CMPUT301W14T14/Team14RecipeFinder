package model;

import android.graphics.Bitmap;


public class UserProfile{
	
	private String userName=null;
	private String biography=null;
	private String twitter=null;
	private String facebook=null;
	private Bitmap photo=null;
	
	public UserProfile(String userName,String biography,String twitter,String facebook,Bitmap photo){
		this.userName=userName;
		this.biography=biography;
		this.twitter=twitter;
		this.facebook=facebook;
		this.photo=photo;
	}

	
	public String getUserName(){
	
		return userName;
	}

	
	public void setUserName(String userName){
	
		this.userName = userName;
	}

	
	public String getBiography(){
	
		return biography;
	}

	
	public void setBiography(String biography){
	
		this.biography = biography;
	}

	
	public String getTwitter(){
	
		return twitter;
	}

	
	public void setTwitter(String twitter){
	
		this.twitter = twitter;
	}

	
	public String getFacebook(){
	
		return facebook;
	}

	
	public void setFacebook(String facebook){
	
		this.facebook = facebook;
	}

	
	public Bitmap getPhoto(){
	
		return photo;
	}

	
	public void setPhoto(Bitmap photo){
	
		this.photo = photo;
	}
}
