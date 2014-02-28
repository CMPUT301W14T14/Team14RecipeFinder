package activity;

import com.example.projectapp.R;
import com.example.projectapp.R.layout;
import com.example.projectapp.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HomePageActivity extends Activity {

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
