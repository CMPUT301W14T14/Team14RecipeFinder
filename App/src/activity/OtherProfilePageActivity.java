package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class OtherProfilePageActivity extends Activity {
	
	private TextView userName=null;
	private TextView biography=null;
	private TextView twitter=null;
	private TextView facebook=null;
	private ImageView profilePicture=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other_profile_page);
		
		// Prepare content of ActionBar
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
		
		userName = (TextView)findViewById(R.id.other_profile_user_name);
		biography = (TextView)findViewById(R.id.other_profile_biography);
		twitter = (TextView)findViewById(R.id.other_profile_twitter);
		facebook = (TextView)findViewById(R.id.other_profile_facebook);
		profilePicture = (ImageView)findViewById(R.id.other_profile_picture);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.other_profile_page, menu);
		return true;
	}

}
