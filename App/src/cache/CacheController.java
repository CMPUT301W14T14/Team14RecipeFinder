package cache;

import model.Comment;
import model.CommentList;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import customlized_gson.GsonConstructor;

/**
 * A controller which used to add Comment in to the shared preferences and load Comment from the sharedPreferences
 */
public class CacheController{
	
	public static final String CACHES_KEY="cachesKey";
	public static final String FAV_SUB_KEY="fav";
	public static final String INDICATED_KEY="indicated";
	private Gson gson=(new GsonConstructor()).getGson();
	
	public CacheController(){}
	
	public CommentList getResource(Activity activity,String tag){
		SharedPreferences caches=activity.getSharedPreferences(CACHES_KEY,0);
		String Json=null;
		if(tag.equals("fav")){
			Json=caches.getString(FAV_SUB_KEY,null);
		}
		else if(tag.equals("indicated")){
			Json=caches.getString(INDICATED_KEY,null);
		}
		CommentList cl=null;
		if(Json==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(Json,CommentList.class);
		}
		return cl;
	}
	
	
	public void addCacheAsTopLevel(Activity activity,Comment comment,String tag){
		SharedPreferences caches=activity.getSharedPreferences(CACHES_KEY,0);
		String key=null;
		if(tag.equals("fav")){
			key=FAV_SUB_KEY;
		}
		else if(tag.equals("indicated")){
			key=INDICATED_KEY;
		}
		String Json=caches.getString(key,null);
		CommentList cl=null;
		if(Json==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(Json,CommentList.class);
		}
		cl.add(comment);
		String newJson=gson.toJson(cl);
		
		caches.edit().putString(key,newJson).commit();
	}
	
	public void addCacheAsReply(Activity activity,String parentID,Comment reply){
		SharedPreferences caches=activity.getSharedPreferences(CACHES_KEY,0);
		String replyJson=caches.getString(parentID,null);
		CommentList cl=null;
		if(replyJson==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(replyJson,CommentList.class);
		}
		cl.add(reply);
		String newJson=gson.toJson(cl);
		caches.edit().putString(parentID,newJson).commit();
	}
	
	public CommentList getReply(String commentID,Activity activity){
		SharedPreferences caches=activity.getSharedPreferences(CACHES_KEY,0);
		String replyJson=caches.getString(commentID,null);
		CommentList cl=null;
		if(replyJson==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(replyJson,CommentList.class);
		}
		return cl;
	}
}
