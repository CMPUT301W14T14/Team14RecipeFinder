package activity;

import com.example.projectapp.R;
import com.example.projectapp.R.id;
import com.example.projectapp.R.layout;
import com.example.projectapp.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
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
		
		userNameInput=(EditText)findViewById(R.id.user_name_input);
		loginButton=(Button)findViewById(R.id.login_button);
	}
	
	

	@Override
	protected void onResume(){
		super.onResume();
		loginButton.setOnClickListener(new LoginClick());
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu){

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class LoginClick implements OnClickListener{

		@Override
		public void onClick(View v){
			String inputUserName=userNameInput.getText().toString();
			//Login / Change Activity
		}
		
	}

}
