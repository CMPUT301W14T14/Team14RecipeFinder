package activity;

import com.example.projectapp.R;
import com.example.projectapp.R.layout;
import com.example.projectapp.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
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
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_info_page, menu);
		return true;
	}

}
