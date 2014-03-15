package activity;

import network_io.IoStreamHandler;

import model.Comment;
import model.CommentMap;

import com.example.projectapp.R;
import com.example.projectapp.UserNameInfo;

import adapter.ListViewAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
/**
 * Activity which mostly contains the view of top level comments
 * @author xuping
 *
 */
public class HomePageActivity extends Activity {
	//private Button sort=null;
	private Button logOut=null;
	private Button userInfo=null;
	//private ListView greatTopic=null;
	private ListView topicList=null;
	private Button createTopic=null;
	private Button refresh=null;
	
	private CommentMap allTopics=null;
	private ListViewAdapter lva=null;
	
	private String userName=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topicpage);
		//sort=(Button)findViewById(R.id.sort1);
		logOut=(Button)findViewById(R.id.logOut);
		userInfo=(Button)findViewById(R.id.userButton1);
		//greatTopic=(ListView)findViewById(R.id.greatTopic);
		topicList=(ListView)findViewById(R.id.topicList);
		createTopic=(Button)findViewById(R.id.createTopic);
		refresh=(Button)findViewById(R.id.refresh);
		
		allTopics=new CommentMap();
		lva=new ListViewAdapter(this,R.layout.single_comment_layout,allTopics.getCurrentList());
		topicList.setAdapter(lva);
		allTopics.setArrayAdapter(lva);
		topicList.setOnItemClickListener(new ViewClick());
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.refresh();
		userName=((UserNameInfo)this.getApplication()).getUserName();
		refresh.setOnClickListener(new RefreshClick());
		createTopic.setOnClickListener(new PublishClick());
		userInfo.setOnClickListener(new UserInfoClick());
		logOut.setOnClickListener(new LogOutClick());
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}
	/**
	 * A method which downloads and refresh the top level comments then shows them in the list view.
	 */
	public void refresh(){
		IoStreamHandler io=new IoStreamHandler();
		allTopics.clear();
		io.loadTopLevelComments(allTopics,this);
	}
	/**
	 * A clickListener which will call the refresh method after click.
	 * @author xuping
	 */
	class RefreshClick implements OnClickListener{
        @Override
		public void onClick(View v){
			refresh();
		}
	}
	/**
	 * A clickListener will direct user to the publishPage (Publish a new top level comment) after click.
	 * If the user logged in as a guest, it will notify user that he cannot publish a comment as a guest.
	 * @author xuping
	 */
	class PublishClick implements OnClickListener{
		/**
		 * Direct user to the publishPage,If the user logged in as a guest, it will notify user that he cannot publish a comment as a guest.
		 */
	    @Override
		public void onClick(View v){
	    	if(userName==null){
	    		Toast.makeText(getApplicationContext(),"Guest cannot publish comment.",Toast.LENGTH_SHORT).show();
	    	}
	    	else{
	    		Intent push_intent=new Intent(HomePageActivity.this,PublishActivity.class);
				push_intent.putExtra("isTopLevel",true);
				startActivity(push_intent);
	    	}
		}
	}
	/**
	 * A OnItemClickListener will direct user to view the content and replies of a specific comment which he/she clicked on (CommentPage Activity)
	 * @author xuping
	 */
	class ViewClick implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3){
			Comment c=(Comment)arg0.getItemAtPosition(pos);
			Intent view_intent=new Intent(HomePageActivity.this,CommentPageActivity.class);
			view_intent.putExtra("comment_id",c.getId());
			startActivity(view_intent);
		}
		
	}
	/**
	 * A ClickListener which starts the user information page(UserInfoPageActivity) after click.
	 * @author xuping
	 */
	class UserInfoClick implements OnClickListener{
		@Override
		public void onClick(View v){
			Intent push_intent=new Intent(HomePageActivity.this,UserInfoPageActivity.class);
			startActivity(push_intent);
		}
	}
	/**
	 * finish the current activity, return to the loginPageActivity after click.
	 * @author xuping
	 */
	class LogOutClick implements OnClickListener{
		@Override
		public void onClick(View v){
			finish();
		}
	}
}
