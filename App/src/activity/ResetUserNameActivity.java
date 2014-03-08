package activity;

import com.example.projectapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ResetUserNameActivity extends Activity{
	
	private EditText typename = null;
	private Button setNameCommit = null;
	private Button setNameCancel = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resetusername);
		typename = (EditText)findViewById(R.id.typename);
		
		setNameCommit = (Button)findViewById(R.id.setNameOk);
		setNameCommit.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				//commit reset user name button click
			}
		});
		
		setNameCancel = (Button)findViewById(R.id.setNameNo);
		setNameCancel.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				//don't reset the user name and close this activity
			}
		});
	}
}
