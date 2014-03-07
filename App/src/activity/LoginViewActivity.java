package activity;

import network_io.UserInfoHandler;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginViewActivity extends Activity{
	//Attributes:
	private EditText userNameInput=null;
	private Button loginButton=null;
	private UserInfoHandler uih=null;

	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_page);
		
		userNameInput=(EditText)findViewById(R.id.user_name_input);
		loginButton=(Button)findViewById(R.id.login_button);
		uih=new UserInfoHandler();
	}
	
	

	@Override
	protected void onResume(){
		super.onResume();
		loginButton.setOnClickListener(listener);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu){

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void loginProcess(String userName){
		uih.loginWithInternet(userName, this);
	}
	
	private View.OnClickListener listener = new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button = (Button)v;
			switch(button.getId()){
			case R.id.login_button:
				// login button click
				String userName = userNameInput.getText().toString();
				loginProcess(userName);
				break;
			}
		}
		
	};

}
