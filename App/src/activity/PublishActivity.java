package activity;

import com.example.projectapp.R;
import com.example.projectapp.R.layout;
import com.example.projectapp.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class PublishActivity extends Activity {

	private Button attach = null;
	private EditText topic = null;
	private EditText content = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.publish);
		attach = (Button)findViewById(R.id.attach);
		topic = (EditText)findViewById(R.id.topictitle);
		content = (EditText)findViewById(R.id.typecontent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.publish, menu);
		return true;
	}

}
