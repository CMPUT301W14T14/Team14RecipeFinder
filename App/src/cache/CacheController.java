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
	private Gson gson=(new GsonConstructor()).getGson();
	
	public CacheController(){}
	
	public CommentList getFav(Activity activity){
		SharedPreferences caches=activity.getSharedPreferences(CACHES_KEY,0);
		String favJson=caches.getString(FAV_SUB_KEY,null);
		CommentList cl=null;
		if(favJson==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(favJson,CommentList.class);
		}
		return cl;
	}
	
	
	public void addFav(Activity activity,Comment comment){
		SharedPreferences caches=activity.getSharedPreferences(CACHES_KEY,0);
		String favJson=caches.getString(FAV_SUB_KEY,null);
		CommentList cl=null;
		if(favJson==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(favJson,CommentList.class);
		}
		cl.add(comment);
		String newJson=gson.toJson(cl);
		caches.edit().putString(FAV_SUB_KEY,newJson).commit();
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
}
