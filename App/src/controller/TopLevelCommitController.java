package controller;

import java.util.ArrayList;

import model.Comment;
import model.CommentList;

import android.content.SharedPreferences;

import com.google.gson.Gson;


public class TopLevelCommitController{
	public static final String rootKey="ROOTKEY";
	private CommentList currentList=null;
	private Gson gson=null;
	private SharedPreferences db=null;
	
	public TopLevelCommitController(SharedPreferences db){
		this.gson=new Gson();
		this.db=db;
		this.currentList=this.gson.fromJson(this.db.getString(rootKey,this.gson.toJson(new CommentList(new ArrayList<Comment>()))),CommentList.class);
	}

	public void commitPublish(Comment comment){
		this.currentList.addComment(comment);
		this.db.edit().putString(rootKey,this.gson.toJson(this.currentList)).commit();
	}

	public void commitEdit(Comment before,Comment after){
		this.currentList.setComment(before, after);
		this.db.edit().putString(rootKey,this.gson.toJson(this.currentList)).commit();
	}
}
