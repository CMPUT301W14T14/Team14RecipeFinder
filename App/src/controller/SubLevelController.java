package controller;

import model.ChildCommentList;
import model.Comment;
import model.CommentList;
import model.CommentPath;
import model.MapNode;
import network_io.IoStreamHandler;
import adapter.ListViewAdapter;
import android.content.Context;

//Don't forget add Commit Edit!
public class SubLevelController{
	private IoStreamHandler io=null;
	private Context context=null;
	
	public SubLevelController(Context context){
		this.io=new IoStreamHandler();
		this.context=context;
	}
	
	private Comment pathHandleOperation(CommentList root,CommentPath path){
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
	
	private CommentList ReverseLinkOperation(Comment c,CommentPath path){
		ChildCommentList current=null;
		for(int i=0;i<path.getDepth()-1;i++){
			current=(ChildCommentList)c.getParentList();
			c=current.getParent();
		}
		return c.getParentList();
		
	}
	
	public ListViewAdapter getUpdatedAdapter(CommentPath path){
		CommentList current=pathHandleOperation(this.io.loadRoot(),path).getReplies();
		ListViewAdapter adapter=new ListViewAdapter(this.context,current.getRandomArray());
		return adapter;
	}
	
	public void commitReply(Comment reply,CommentPath path){
		Comment c=pathHandleOperation(this.io.loadRoot(),path);
		ChildCommentList current=c.getReplies();
		current.addComment(reply);
		c.setReplies(current);
		CommentList resultRoot=ReverseLinkOperation(c,path);
		this.io.commitUpdate(resultRoot);
	}
	
	public void commitEdit(Comment after,CommentPath path){
		CommentList resultRoot=ReverseLinkOperation(after,path);
		this.io.commitUpdate(resultRoot);
	}
}
