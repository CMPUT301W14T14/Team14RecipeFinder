package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.ArrayAdapter;
/**
 * A class used to store Comment Objects downloaded from the server and able to return a list which can used by list view adapter construct
 * @author xuping
 *
 */

public class CommentMap{
	private Map<String,Comment> comments=null;
	private ArrayList<Comment> comments_list=null;
	private ArrayAdapter<Comment> adapter=null;
	
	/**
	 * Construct a empty CommentMap object 
	 */
	
	public CommentMap(){
		this.comments=new HashMap<String,Comment>();
		this.comments_list=new ArrayList<Comment>();
	}
	
	/**
	 * Update a Comment object in the CommentMap with its own id, if no Comment with the same ID exists, then added the Comment object to the CommentMap, notify the ArrayAdapter<Comment> the data set has changed
	 * after update if the ArrayAdapter<Comment> has been set.
	 */
	public void updateComment(Comment comment){
		this.comments.put(comment.getId(),comment);
		this.comments_list.add(comment);
		if(this.adapter!=null){
			this.adapter.notifyDataSetChanged();
		}
	}
	
	/**
	 * Get a specific Comment with its own id from the CommentMap.
	 */
	
	public Comment getComment(String id){
		return this.comments.get(id);
	}
	
	/**
	 * Get a unmodifiable list which contains all Comment objects in this CommentMap which can be used to construct a list view adapter.
	 */
	
	public List<Comment> getCurrentList(){
		return Collections.unmodifiableList(this.comments_list);
	}
	/**
	 * Set this CommentMap's ArrayAdapter.
	 * @param adapter
	 */
	public void setArrayAdapter(ArrayAdapter<Comment> adapter){
		this.adapter=adapter;
	}
	
	/**
	 * Empty this CommentMap and notify the ArrayAdapter data set has changed if ArrayAdapter has been set.
	 */
	public void clear(){
		this.comments.clear();
		this.comments_list.clear();
		if(this.adapter!=null){
			this.adapter.notifyDataSetChanged();
		}
	}
}
