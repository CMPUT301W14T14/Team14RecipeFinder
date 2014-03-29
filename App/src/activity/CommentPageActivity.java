package activity;


import user_name.UserNameHandler;
import network_io.ConnectionChecker;
import network_io.IoStreamHandler;
import model.Comment;
import model.CommentMap;

import cache.CacheController;

import com.example.projectapp.R;

import adapter.ListViewAdapter;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CommentPageActivity extends Activity {
	
	private TextView title=null;
	private TextView content=null;
	private TextView commentInfo=null;
	private ImageView picture=null;
	private ImageButton like=null;
	private ImageButton bookmark=null;
	private ImageButton edit=null;
	private ListView listView=null;
	
	private CommentMap replies=null;
	private ListViewAdapter listViewAdapter=null;
	private IoStreamHandler io=null;
	private ConnectionChecker connectionChecker=null;
	
	private String commentID=null;
	private String authorName=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comment_page);
		
		// Initialize Menu bar
		initView();
		
		title = (TextView)findViewById(R.id.comment_title);
		content = (TextView)findViewById(R.id.comment_content);
		commentInfo = (TextView)findViewById(R.id.comment_info);
		picture = (ImageView)findViewById(R.id.topic_image);
		like = (ImageButton)findViewById(R.id.comment_like);
		bookmark = (ImageButton)findViewById(R.id.comment_bookmark);
		edit = (ImageButton)findViewById(R.id.comment_edit);
		listView = (ListView)findViewById(R.id.reply_list);
		
		io=new IoStreamHandler();
		connectionChecker=new ConnectionChecker();
		replies=new CommentMap();
		listViewAdapter=new ListViewAdapter(this,R.layout.single_comment_layout,replies.getCurrentList());
		listView.setAdapter(listViewAdapter);
		replies.setArrayAdapter(listViewAdapter);
		
		commentID=((getIntent()).getStringExtra("commentID"));
		authorName=((getIntent()).getStringExtra("authorName"));
		
		listView.setOnItemClickListener(new RecurViewClick());
		
		edit.setOnClickListener(new EditClick());
		like.setOnClickListener(new LikeClick());
		bookmark.setOnClickListener(new MarkClick());
	}
	
	
	@Override
	protected void onResume(){
		super.onResume();
		refresh();
	}
	
	class EditClick implements OnClickListener{

		@Override
		public void onClick(View v){
			if(!authorName.equals((new UserNameHandler()).getUserName(CommentPageActivity.this))){
				Toast.makeText(getApplicationContext(),"Only author can edit comment.",Toast.LENGTH_SHORT).show();
			}
			else if(connectionChecker.isNetworkOnline(CommentPageActivity.this)==false){
				Toast.makeText(getApplicationContext(),"Offline.",Toast.LENGTH_SHORT).show();
			}
			else{
				Intent pushIntent=new Intent(CommentPageActivity.this,EditCommentPageActivity.class);
				pushIntent.putExtra("commentID",commentID);
				startActivity(pushIntent);
			}
		}
		
	}
	
	class LikeClick implements OnClickListener{
		@Override
		public void onClick(View v){
			if(connectionChecker.isNetworkOnline(CommentPageActivity.this)==false){
				Toast.makeText(getApplicationContext(),"Offline.",Toast.LENGTH_SHORT).show();
				return;
			}
			CacheController cc=new CacheController();
			io.addCache(commentID,null,cc,"fav",CommentPageActivity.this);
			Toast.makeText(getApplicationContext(),"Liked.",Toast.LENGTH_SHORT).show();
		}
	}
	
	class MarkClick implements OnClickListener{
		@Override
		public void onClick(View v){
			if(connectionChecker.isNetworkOnline(CommentPageActivity.this)==false){
				Toast.makeText(getApplicationContext(),"Offline.",Toast.LENGTH_SHORT).show();
				return;
			}
			CacheController cc=new CacheController();
			io.addCache(commentID,null,cc,"indicated",CommentPageActivity.this);
			Toast.makeText(getApplicationContext(),"Marked.",Toast.LENGTH_SHORT).show();
		}
	}

	class RecurViewClick implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0,View arg1,int pos,long arg3){
			Comment comment=(Comment)arg0.getItemAtPosition(pos);
			Intent viewIntent=new Intent(CommentPageActivity.this,CommentPageActivity.class);
			viewIntent.putExtra("commentID",comment.getId());
			viewIntent.putExtra("authorName",comment.getUserName());
			startActivity(viewIntent);
		}
		
	}
	
	private void refresh(){
		if(connectionChecker.isNetworkOnline(this)){
			replies.clear();
			io.loadAndSetSpecificComment(commentID,title,content,commentInfo,picture,replies,this);
		}
		else{
			Toast.makeText(getApplicationContext(),"Offline",Toast.LENGTH_SHORT).show();
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

		case R.id.action_create:
			intent = new Intent(this, CreateCommentPageActivity.class);
			intent.putExtra("parentID",commentID);
			startActivity(intent);
			return true;
		case R.id.action_favorite:
			 intent = new Intent(this, FavoritePageActivity.class);
			 startActivity(intent);
			 return true;
		case R.id.action_my_comment:
			intent = new Intent(this,FavoritePageActivity.class);
			intent.putExtra("isFav",false);
			startActivity(intent);
			return true;
		case R.id.action_profile:
			intent = new Intent(this, ProfilePageActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_refresh:
			refresh();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comment_page, menu);
		return true;
	}

}
