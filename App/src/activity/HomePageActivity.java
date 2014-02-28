package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
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
		sort = (Button)findViewById(R.id.sort);
		laterList = (Button)findViewById(R.id.LaterList);
		userInfo = (Button)findViewById(R.id.userinfo);
		createNew = (Button)findViewById(R.id.createnew);
		greatTopic = (ListView)findViewById(R.id.GreatTopic);
		topicList = (ListView)findViewById(R.id.TopicList);
		userInfoText = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
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
			case R.id.sort:
				//sort button click
				
				break;
			case R.id.LaterList:
				//laterlist button click
				
				break;
			case R.id.userinfo:
				//userinfo button click
				
				break;
			case R.id.createnew:
				//createnew button click
				
				break;
			}
		}
	};
}
