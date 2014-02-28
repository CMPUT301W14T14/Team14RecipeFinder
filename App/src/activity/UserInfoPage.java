package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserInfoPage extends Activity {
	
	private TextView username = null;
	private Button logout = null;
	private Button back = null;
	private Button favorite = null;
	private Button viewedtopic = null;
	private Button resetname = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userinfopage);
		username = (TextView)findViewById(R.id.username);
		logout = (Button)findViewById(R.id.logout);
		back = (Button)findViewById(R.id.userinfoBack);
		favorite = (Button)findViewById(R.id.favourite);
		viewedtopic = (Button)findViewById(R.id.historytopic);
		resetname = (Button)findViewById(R.id.setname);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		logout.setOnClickListener(listener);
		favorite.setOnClickListener(listener);
		viewedtopic.setOnClickListener(listener);
		resetname.setOnClickListener(listener);
		back.setOnClickListener(listener);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_info_page, menu);
		return true;
	}

	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button = (Button)v;
			switch(button.getId()){
			case R.id.logout:
				//logout button click
				
				break;
			case R.id.favourite:
				//favorite button click
				
				break;
			case R.id.historytopic:
				//Viewed Topic button click
				
				break;
			case R.id.setname:
				// reset name button click
				
				break;
			case R.id.userinfoBack:
				// back button click
				
				break;
			}
		}
	};
}
