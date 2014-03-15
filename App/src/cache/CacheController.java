package cache;

import model.Comment;
import model.CommentList;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import customlized_gson.Gson_Constructor;

/**
 * A controller which used to add Comment in to the sharedpreferences and load Comment from the sharedPreferences
 * @author xuping
 *
 */
public class CacheController{
	
	public static final String cacheKey="CACHES";
	public static final String favSubKey="FAVOURITES";
	private Gson gson=null;
	/**
	 * Construct a CacheController object
	 */
	public CacheController(){
		this.gson=(new Gson_Constructor()).getGson();
	}
	/**
	 * @param activity Activity where this function will be called.
	 * @return a CommentList Contains all comments which local cached as favorite comment(a CommentList pointed by key "FAVOURITES"), if there's no such CommentList,method returns an empty CommentList.
	 */
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
	/**
	 * Add a new comment in to sharedpreferences as favorite comment,(into a CommentList pointed by key "FAVOURITES") if the CommentList not exist, a new CommentList will be created and the
	 * given Comment will be added, then that CommentList will be stored as a CommentList pointed by key "FAVOURITES".
	 * @param activity Activity where this function will be called.
	 * @param comment a Comment object.
	 */
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
	/**
	 * Add a new comment in to sharedpreferences,(into a CommentList pointed by a key which is the same as the given comment's parent's id) if the CommentList not exist, a new CommentList will be created and the
	 * given Comment will be added, then that CommentList will be stored as a CommentList pointed by a key equals the given comment's parent's id.
	 * @param activity Activity where this function will be called.
	 * @param parentId a String which is the parent comment id.
	 * @param reply a Comment object.
	 */
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
		String newJson=gson.toJson(cl);
		caches.edit().putString(parentId,newJson).commit();
	}
}
