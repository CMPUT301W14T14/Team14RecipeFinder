package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class HomePageActivity extends Activity {

	private Button sort = null;
	private Button laterList = null;
	private Button userInfo = null;
	private Button createNew = null;
	private ListView greatTopic = null;
	private ListView topicList = null;
	private AutoCompleteTextView userInfoText = null;
	private ImageView picture = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topicpage);
		sort = (Button)findViewById(R.id.sort1);
		laterList = (Button)findViewById(R.id.LaterList1);
		userInfo = (Button)findViewById(R.id.userbutton1);
		createNew = (Button)findViewById(R.id.createTopic);
		greatTopic = (ListView)findViewById(R.id.GreatTopic);
		topicList = (ListView)findViewById(R.id.TopicList);
		userInfoText = (AutoCompleteTextView)findViewById(R.id.userinfo1);
		picture = (ImageView)findViewById(R.id.picture);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sort.setOnClickListener(listener);
		userInfo.setOnClickListener(listener);
		laterList.setOnClickListener(listener);
		createNew.setOnClickListener(listener);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}

	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button = (Button)v;
			switch (button.getId()){
			case R.id.sort1:
				//sort button click
				Intent intent_sort = new Intent();
				intent_sort.setClass(HomePageActivity.this, SortOptionActivity.class);
				HomePageActivity.this.startActivity(intent_sort);
				break;
			case R.id.LaterList1:
				//laterlist button click
				
				break;
			case R.id.userinfo1:
				//userinfo button click
				
				break;
			case R.id.createTopic:
				//createnew button click
				
				break;
			}
		}
	};
}
