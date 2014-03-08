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
	private String newusername = null;
	UserNameInfo resetnameglobol = ((UserNameInfo)this.getApplication());
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resetusername);
		
		typename = (EditText)findViewById(R.id.typename);
		newusername = typename.getText().toString(); 
		
		setNameCommit = (Button)findViewById(R.id.setNameOk);
		setNameCommit.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				//commit reset user name button click
				resetnameglobol.setUserName(newusername);
				finish();
			}
		});
		
		setNameCancel = (Button)findViewById(R.id.setNameNo);
		setNameCancel.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				//don't reset the user name and close this activity
				finish();
			}
		});
	}
}
