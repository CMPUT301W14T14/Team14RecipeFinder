package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;

public class HomePageActivity extends Activity {

	private Button sort = null;
	private Button laterList = null;
	private Button userInfo = null;
	private Button createNew = null;
	private ListView greatTopic = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topicpage);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}

}
