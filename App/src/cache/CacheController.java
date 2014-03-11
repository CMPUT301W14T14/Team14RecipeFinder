package cache;

import model.Comment;
import model.CommentList;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import customlized_gson.Gson_Constructor;


public class CacheController{
	
	public static final String cacheKey="CACHES";
	public static final String favSubKey="FAVOURITES";
	private Gson gson=null;
	
	public CacheController(){
		this.gson=(new Gson_Constructor()).getGson();
	}
	
	public CommentList loadFav(Activity activity){
		SharedPreferences caches=activity.getSharedPreferences(cacheKey,0);
		String favJson=caches.getString(favSubKey,null);
		CommentList cl=null;
		if(favJson==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(favJson,CommentList.class);
		}
		return cl;
	}
	
	public void AddFav(Activity activity,Comment comment){
		SharedPreferences caches=activity.getSharedPreferences(cacheKey,0);
		String favJson=caches.getString(favSubKey,null);
		CommentList cl=null;
		if(favJson==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(favJson,CommentList.class);
		}
		cl.add(comment);
		String newJson=gson.toJson(cl);
		caches.edit().putString(favSubKey,newJson).commit();
	}
	
	public void AddCacheReply(Activity activity,String parentId,Comment reply){
		SharedPreferences caches=activity.getSharedPreferences(cacheKey,0);
		String replyJson=caches.getString(parentId,null);
		CommentList cl=null;
		if(replyJson==null){
			cl=new CommentList();
		}
		else{
			cl=gson.fromJson(replyJson,CommentList.class);
		}
		cl.add(reply);
		System.out.println(cl.getCurrentList());
		String newJson=gson.toJson(cl);
		caches.edit().putString(parentId,newJson).commit();
	}
}
