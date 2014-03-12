package activity;


//import network_io.IoStreamHandler;

import com.example.projectapp.R;
import com.example.projectapp.UserNameInfo;

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

	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_page);
		
		//IoStreamHandler io=new IoStreamHandler();
		//io.Clean();
		
		userNameInput=(EditText)findViewById(R.id.user_name_input);
		loginButton=(Button)findViewById(R.id.login_button);
	}
	
	

	@Override
	protected void onResume(){
		super.onResume();
		loginButton.setOnClickListener(listener);
	}
	
	protected void setUserName(String userName){
		((UserNameInfo)this.getApplication()).setUserName(userName);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu){

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private View.OnClickListener listener = new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			Button button = (Button)v;
			switch(button.getId()){
			case R.id.login_button:
				String userName = userNameInput.getText().toString();
				if(userName.equals("")==false){
					setUserName(userName);
				}
				else{
					setUserName(null);
				}
				Intent intent=new Intent(LoginViewActivity.this,HomePageActivity.class);
				startActivity(intent);
				break;
			}
		}
		
	};

}
