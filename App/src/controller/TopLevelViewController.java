package controller;


import java.util.ArrayList;

import model.Comment;
import model.CommentList;

import com.google.gson.Gson;

import customlized_gson.Gson_Constructor;

import adapter.ListViewAdapter;
import android.content.Context;
import android.content.SharedPreferences;


public class TopLevelViewController{
	public static final String rootKey="ROOTKEY";
	private CommentList currentList=null;
	private Gson gson=null;
	private Context context=null;
	
	public TopLevelViewController(Context context){
		this.gson=new Gson_Constructor().getGson();
		this.context=context;
	}
	
	public ListViewAdapter getUpdatedAdapter(SharedPreferences db){
		this.currentList=this.gson.fromJson(db.getString(rootKey,this.gson.toJson(new CommentList(new ArrayList<Comment>()))),CommentList.class);
		ListViewAdapter adapter=new ListViewAdapter(this.context,this.currentList.getRandomArray());
		return adapter;
	}
}
