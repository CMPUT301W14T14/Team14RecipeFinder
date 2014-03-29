package activity;

import java.util.Date;

import model.Comment;
import model.CommentList;

import cache.CacheController;

import com.example.projectapp.R;
import com.google.gson.Gson;

import customlized_gson.GsonConstructor;

import adapter.ListViewAdapter;
import android.location.Location;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class LocalCommentPageActivity extends Activity {

	private TextView title=null;
	private TextView content=null;
	private TextView commentInfo=null;
	private ImageView picture=null;
	private ListView listView=null;
	
	private Gson gson=(new GsonConstructor()).getGson();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local_comment_page);
		
		// Initialize Menu bar
		initView();
		
		title = (TextView)findViewById(R.id.local_comment_title);
		content = (TextView)findViewById(R.id.local_comment_content);
		commentInfo = (TextView)findViewById(R.id.local_comment_info);
		picture = (ImageView)findViewById(R.id.local_topic_image);
		listView = (ListView)findViewById(R.id.local_reply_list);
		
		Intent intent=getIntent();
		Comment comment=gson.fromJson(intent.getStringExtra("commentJson"),Comment.class);
		title.setText(comment.getTitle());
		content.setText(comment.getText());
		picture.setImageBitmap(comment.getPicture());
		Location location=comment.getLocation();
		if(location!=null){
			double lat=location.getLatitude();
			double lng=location.getLongitude();
			String lngS=String.valueOf(lng);
			String latS=String.valueOf(lat);
			commentInfo.setText("Posted By : "+comment.getUserName()+" At : "+((new Date(comment.getTimePosted())).toString())+"\nLocation At: Longitude: "+lngS+"  Latitude: "+latS);
		}
		else{
			commentInfo.setText("Posted By : "+comment.getUserName()+" At : "+((new Date(comment.getTimePosted())).toString()));
		}
		CommentList replies=(new CacheController()).getReply(comment.getId(),this);
		ListViewAdapter listViewAdapter=new ListViewAdapter(this,R.layout.single_comment_layout,replies.getCurrentList());
		listView.setAdapter(listViewAdapter);
		listView.setOnItemClickListener(new RecurLocalView());
		
	}
	
	class RecurLocalView implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3){
			Intent pushIntent=new Intent(LocalCommentPageActivity.this,LocalCommentPageActivity.class);
			pushIntent.putExtra("commentJson",gson.toJson((Comment)arg0.getItemAtPosition(pos)));
			startActivity(pushIntent);
		}
		
	}
	
	/**
	 *  Initialize View. Get ActionBar to enable title and disable title.
	 */
	private void initView() {
		// ActionBar
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {

		case R.id.action_favorite:
			 intent = new Intent(this, FavoritePageActivity.class);
			 startActivity(intent);
			 return true;
		case R.id.action_my_comment:
			intent = new Intent(this, MyCommentPageActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_profile:
			intent = new Intent(this, ProfilePageActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.local_comment_page, menu);
		return true;
	}

}
