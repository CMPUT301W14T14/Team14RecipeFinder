package activity;

import model.User;
import network_io.UserInfoHandler;

import com.example.projectapp.R;
import com.google.gson.Gson;

import controller.UserInfoController;
import customlized_gson.Gson_Constructor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginViewActivity extends Activity{
	//Attributes:
	private EditText userNameInput=null;
	private Button loginButton=null;
	private UserInfoController uic=null;
	private UserInfoHandler uih=null;

	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_page);
		
		userNameInput=(EditText)findViewById(R.id.user_name_input);
		loginButton=(Button)findViewById(R.id.login_button);
		uic=new UserInfoController();
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
	
	public void getUserInfo(String userName){
		uih.getUserInfo(userName, uic, this);
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
				getUserInfo(userName);
				User user=uic.getUser();
				// Go to sever to check user name.
				// Skip check whether it resist
				Intent intent = new Intent();
				Gson gson=(new Gson_Constructor()).getGson();
				intent.putExtra("user", gson.toJson(user));
				intent.setClass(LoginViewActivity.this, HomePageActivity.class);
				LoginViewActivity.this.startActivity(intent);
				break;
			}
		}
		
	};

}
