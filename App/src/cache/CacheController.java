package cache;

import model.CommentMap;

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
	
	public CommentMap loadFav(Activity activity){
		SharedPreferences caches=activity.getSharedPreferences(cacheKey,0);
		String favJson=caches.getString(favSubKey,null);
		CommentMap fav=null;
		if(favJson==null){
			fav=new CommentMap();
		}
		else{
			fav=gson.fromJson(favJson,CommentMap.class);
		}
		return fav;
	}
}
