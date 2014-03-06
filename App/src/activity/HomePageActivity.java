package activity;

import java.util.ArrayList;

import network_io.IoStreamHandler;

import model.CommentMap;

import com.example.projectapp.R;

import controller.AdapterConstructor;

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
	private Button userinfo=null;
	//private ListView greatTopic=null;
	private ListView topicList=null;
	private Button createTopic=null;
	private Button refresh=null;
	
	private CommentMap allTopics=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topicpage);
		//sort=(Button)findViewById(R.id.sort1);
		//laterList=(Button)findViewById(R.id.laterList1);
		userinfo=(Button)findViewById(R.id.userButton1);
		//greatTopic=(ListView)findViewById(R.id.greatTopic);
		topicList=(ListView)findViewById(R.id.topicList);
		createTopic=(Button)findViewById(R.id.createTopic);
		refresh=(Button)findViewById(R.id.refresh);
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.refresh();
		refresh.setOnClickListener(new RefreshClick());
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}
	
	public void refresh(){
		ArrayList<String> TopicIdSet=new ArrayList<String>();
		IoStreamHandler io=new IoStreamHandler();
		io.loadTopLevelIdSet(TopicIdSet,this);
		allTopics=new CommentMap();
		for(String commentId : TopicIdSet){
			io.loadSpecificComment(commentId,allTopics,this);
		}
		AdapterConstructor adapterConstructor=new AdapterConstructor(this);
		topicList.setAdapter(adapterConstructor.getAdapterNotSorted(allTopics));
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
			Intent intent=new Intent(HomePageActivity.this,PublishActivity.class);
		}
	}
}
