package controller;

import model.Comment;
import model.CommentList;
import model.CommentPath;
import model.MapNode;
import network_io.IoStreamHandler;
import adapter.ListViewAdapter;
import android.content.Context;


public class SubLevelController{
	private IoStreamHandler io=null;
	private Context context=null;
	
	public SubLevelController(Context context){
		this.io=new IoStreamHandler();
		this.context=context;
	}
	
	private Comment pathHandler(CommentList root,CommentPath path){
		CommentList current=root;
		Comment c=null;
		for(MapNode mn : path.getMap()){
			c=current.getSpecfic(mn.getUserId(),mn.getTimePosted());
			if(c==null){
				System.out.println("Error: no such comment.");
				return null;
			}
			else{
				current=c.getReplies();
			}
		}
		return c;
	}
	
	public ListViewAdapter getUpdatedAdapter(CommentPath path){
		CommentList current=pathHandler(this.io.loadRoot(),path).getReplies();
		ListViewAdapter adapter=new ListViewAdapter(this.context,current.getRandomArray());
		return adapter;
	}
}
