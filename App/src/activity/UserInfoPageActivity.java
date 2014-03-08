package activity;

import com.example.projectapp.R;
import com.example.projectapp.UserNameInfo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserInfoPageActivity extends Activity {
	
	private TextView userName = null;
	private Button logOut = null;
	private Button favorite = null;
	private Button viewedTopic = null;
	private Button resetName = null;
	private String pageUseName = null;
	UserNameInfo userinfoglobol = ((UserNameInfo)this.getApplication());
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userinfopage);
		userName = (TextView)findViewById(R.id.username);
		pageUseName = userinfoglobol.getUserName();
		userName.setText(pageUseName);
		
		logOut = (Button)findViewById(R.id.logout);
		favorite = (Button)findViewById(R.id.favourite);
		viewedTopic = (Button)findViewById(R.id.historytopic);
		resetName = (Button)findViewById(R.id.setname);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		logOut.setOnClickListener(listener);
		favorite.setOnClickListener(listener);
		viewedTopic.setOnClickListener(listener);
		resetName.setOnClickListener(listener);
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
				Intent logoutintent = new Intent();
				logoutintent.setClass(UserInfoPageActivity.this, LoginViewActivity.class);
				UserInfoPageActivity.this.startActivity(logoutintent);
				break;
				
			case R.id.favourite:
				//favorite button click
				Intent favouriteintent = new Intent();
				favouriteintent.setClass(UserInfoPageActivity.this, ViewHistoryActivity.class);
				UserInfoPageActivity.this.startActivity(favouriteintent);
				break;
				
			case R.id.historytopic:
				//Viewed Topic button click
				Intent historyintent = new Intent();
				historyintent.setClass(UserInfoPageActivity.this, ViewHistoryActivity.class);
				UserInfoPageActivity.this.startActivity(historyintent);				
				break;
				
			case R.id.setname:
				// reset name button click
				Intent setnameintent = new Intent();
				setnameintent.setClass(UserInfoPageActivity.this, ResetUserNameActivity.class);
				UserInfoPageActivity.this.startActivity(setnameintent);	
				break;
			}
		}
	};
}
