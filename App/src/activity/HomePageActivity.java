package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;

public class HomePageActivity extends Activity {
	Button sort=null;
	Button laterList=null;
	Button userinfo=null;
	ListView greatTopic=null;
	ListView topicList=null;
	Button createTopic=null;
	Button refresh=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topicpage);
		sort=(Button)findViewById(R.id.sort1);
		laterList=(Button)findViewById(R.id.laterList1);
		userinfo=(Button)findViewById(R.id.userButton1);
		greatTopic=(ListView)findViewById(R.id.greatTopic);
		topicList=(ListView)findViewById(R.id.topicList);
		createTopic=(Button)findViewById(R.id.createTopic);
		refresh=(Button)findViewById(R.id.refresh);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}
	
	public void loadAll(){
		
	}
}
