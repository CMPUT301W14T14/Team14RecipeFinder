package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.ArrayAdapter;


public class CommentMap{
	private Map<String,Comment> comments=null;
	private ArrayList<Comment> comments_list=null;
	private ArrayAdapter<Comment> adapter=null;
	
	/**
	 * construct a commentMap object 
	 */
	
	public CommentMap(){
		this.comments=new HashMap<String,Comment>();
		this.comments_list=new ArrayList<Comment>();
	}
	
	/**
	 * update a comment in the comment map with its own id, if the comment is not exist, then added it to the map
	 */
	public void updateComment(Comment comment){
		this.comments.put(comment.getId(),comment);
		this.comments_list.add(comment);
		if(this.adapter!=null){
			this.adapter.notifyDataSetChanged();
		}
	}
	
	/**
	 * get a specific comment with its own id from the map
	 */
	
	public Comment getComment(String id){
		return this.comments.get(id);
	}
	
	/**
	 * get a list of comment in this map
	 */
	
	public List<Comment> getCurrentList(){
		return Collections.unmodifiableList(this.comments_list);
	}
	
	public void setArrayAdapter(ArrayAdapter<Comment> adapter){
		this.adapter=adapter;
	}
	
	public void clear(){
		this.comments.clear();
		this.comments_list.clear();
		if(this.adapter!=null){
			this.adapter.notifyDataSetChanged();
		}
	}
}
