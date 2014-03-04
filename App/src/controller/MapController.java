package controller;

import model.CommentPath;

import com.google.gson.Gson;

import customlized_gson.Gson_Constructor;


public class MapController{
	private Gson gson=null;
	
	public MapController(){
		this.gson=new Gson_Constructor().getGson();
	}
	
	public String getJsonString(CommentPath map){
		return this.gson.toJson(map);
	}
	
	public CommentPath getCommentPath(String jsonString){
		return this.gson.fromJson(jsonString,CommentPath.class);
	}
}
