package activity;

import com.example.projectapp.R;
import com.example.projectapp.UserNameInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ResetUserNameActivity extends Activity{
	
	private EditText typename = null;
	private Button setNameCommit = null;
	private Button setNameCancel = null;
	
	
	protected void setUserName(String userName){
		((UserNameInfo)this.getApplication()).setUserName(userName);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resetusername);
		
		typename = (EditText)findViewById(R.id.type_new_user_name); 
		
		setNameCommit = (Button)findViewById(R.id.setNameOk);
		setNameCommit.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				String newUserName = typename.getText().toString();
				setUserName(newUserName);
				finish();
			}
		});
		
		setNameCancel = (Button)findViewById(R.id.setNameNo);
		setNameCancel.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				finish();
			}
		});
	}
}
