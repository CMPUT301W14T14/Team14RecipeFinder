package controller;

import network_io.IoStreamHandler;
import model.Comment;
import model.CommentList;
import adapter.ListViewAdapter;
import android.content.Context;


public class TopLevelController{
	private IoStreamHandler io=null;
	private Context context=null;
	
	public TopLevelController(Context context){
		this.io=new IoStreamHandler();
		this.context=context;
	}
	
	public ListViewAdapter getUpdatedAdapter(){
		CommentList root=this.io.loadRoot();
		ListViewAdapter adapter=new ListViewAdapter(this.context,root.getRandomArray());
		return adapter;
	}
	
	public void commitPublish(Comment comment){
		CommentList root=this.io.loadRoot();
		root.addComment(comment);
		this.io.commitUpdate(root);
	}
}
