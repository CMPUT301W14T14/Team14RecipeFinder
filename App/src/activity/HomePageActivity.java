package activity;

import network_io.IoStreamHandler;

import model.CommentMap;
import model.IdSet;

import com.example.projectapp.R;

import controller.AdapterConstructor;

import adapter.ListViewAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class HomePageActivity extends Activity {
	//private Button sort=null;
	//private Button laterList=null;
	//private Button userInfo=null;
	//private ListView greatTopic=null;
	private ListView topicList=null;
	private Button createTopic=null;
	private Button refresh=null;
	
	private String userJson=null;
	private IdSet IdSet=null;
	private CommentMap allTopics=null;
	private ListViewAdapter lva=null;
	
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
		
		Intent intent=getIntent();
		userJson=intent.getStringExtra("user");
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.refresh();
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
		IdSet=new IdSet();
		IoStreamHandler io=new IoStreamHandler();
		io.loadTopLevelIdSet(IdSet,this);
		allTopics=new CommentMap();
		System.out.println(IdSet.getSet());
		for(String commentId : IdSet.getSet()){
			io.loadSpecificComment(commentId,allTopics,this);
		}
		AdapterConstructor adapterConstructor=new AdapterConstructor(this);
		lva=adapterConstructor.getAdapterNotSorted(allTopics);
		topicList.setAdapter(lva);
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
			Intent push_intent=new Intent(HomePageActivity.this,PublishActivity.class);
			push_intent.putExtra("user",userJson);
			push_intent.putExtra("isTopLevel",true);
			startActivity(push_intent);
		}
	}
}
