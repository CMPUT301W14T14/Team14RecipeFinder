package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LocalCommentPageActivity extends Activity {

	private TextView title=null;
	private TextView content=null;
	private TextView commentInfo=null;
	private ImageView picture=null;
	private ListView listView=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local_comment_page);
		
		// Initialize Menu bar
		initView();
		
		title = (TextView)findViewById(R.id.comment_title);
		content = (TextView)findViewById(R.id.comment_content);
		commentInfo = (TextView)findViewById(R.id.comment_info);
		picture = (ImageView)findViewById(R.id.topic_image);
		listView = (ListView)findViewById(R.id.reply_list);
		
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
