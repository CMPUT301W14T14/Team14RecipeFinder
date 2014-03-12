package activity;

import java.util.Date;

import model.Comment;
import model.CommentList;

import com.example.projectapp.R;
import com.google.gson.Gson;

import customlized_gson.Gson_Constructor;

import adapter.ListViewAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ViewCacheCommentActivity extends Activity{
	
	public static final String cacheKey="CACHES";
	
	//private Button sort=null;
	private TextView content=null;
	private TextView authorInfo=null;
	private ImageView pic=null;
	private ListView reply=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favouritecomment);
		//sort=(Button)findViewById(R.id.sort4);
		content=(TextView)findViewById(R.id.contentText);
		authorInfo=(TextView)findViewById(R.id.authorInfo2);
		pic=(ImageView)findViewById(R.id.cachePic);
		pic.setImageBitmap(null);
		reply=(ListView)findViewById(R.id.replyList);
		
		Gson gson=(new Gson_Constructor()).getGson();
		Intent intent=getIntent();
		Comment c=gson.fromJson(intent.getStringExtra("comment"),Comment.class);
		content.setText(c.getText());
		authorInfo.setText("Posted by: "+c.getUserName()+" At "+(new Date(c.getTimePosted())).toString());
		//location display not added!!!!!!!!!!!!!
		
		SharedPreferences caches=getSharedPreferences(cacheKey,0);
		CommentList replies=gson.fromJson(caches.getString(c.getId(),null),CommentList.class);
		ListViewAdapter lva=new ListViewAdapter(this,R.layout.single_comment_layout,replies.getCurrentList());
		reply.setAdapter(lva);
	}
}
