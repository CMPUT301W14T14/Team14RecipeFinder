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

public class HomePageActivity extends Activity {
	//private Button sort=null;
	//private Button laterList=null;
	//private Button userInfo=null;
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
		//laterList=(Button)findViewById(R.id.laterList1);
		//userInfo=(Button)findViewById(R.id.userButton1);
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
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}
	
	public void refresh(){
		IoStreamHandler io=new IoStreamHandler();
		allTopics.clear();
		io.loadTopLevelComments(allTopics,this);
	}
	
	class RefreshClick implements OnClickListener{
        @Override
		public void onClick(View v){
			refresh();
		}
	}
	
	class PublishClick implements OnClickListener{
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
	
	class ViewClick implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3){
			Comment c=(Comment)arg0.getItemAtPosition(pos);
			Intent view_intent=new Intent(HomePageActivity.this,CommentPageActivity.class);
			view_intent.putExtra("comment_id",c.getId());
			startActivity(view_intent);
		}
		
	}
}
