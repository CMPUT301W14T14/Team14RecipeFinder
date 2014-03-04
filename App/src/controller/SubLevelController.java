package controller;

import model.ChildCommentList;
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
	
	public Comment pathHandleOperation(CommentList root,CommentPath path){
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
	
	private CommentList ReverseLinkOperation(Comment c,CommentList root,CommentPath path){
		for(int i=0;i<path.getDepth()-1;i++){
			c=c.getParent();
		}
		root.updateComment(c);
		return root;
	}
	
	public ListViewAdapter getUpdatedAdapter(CommentPath path){
		CommentList current=pathHandleOperation(this.io.loadRoot(),path).getReplies();
		ListViewAdapter adapter=new ListViewAdapter(this.context,current.getRandomArray());
		return adapter;
	}
	
	public void commitReply(Comment reply,CommentPath path){
		CommentList root=this.io.loadRoot();
		Comment c=pathHandleOperation(root,path);
		ChildCommentList current=c.getReplies();
		current.addComment(reply);
		c.setReplies(current);
		CommentList resultRoot=ReverseLinkOperation(c,root,path);
		this.io.commitUpdate(resultRoot);
	}
	
	public void commitEdit(Comment after,CommentPath path){
		CommentList root=this.io.loadRoot();
		CommentList resultRoot=ReverseLinkOperation(after,root,path);
		this.io.commitUpdate(resultRoot);
	}
}
