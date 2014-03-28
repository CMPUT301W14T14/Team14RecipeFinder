package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class EditCommentPageActivity extends Activity {
	
	private EditText title=null;
	private EditText content=null;
	private EditText latitude=null;
	private EditText longitude=null;
	private ImageView picture=null;
	private ImageButton commit=null;
	private ImageButton cancel=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_comment_page);
		
		// Initialize View
		initView();
		
		title = (EditText)findViewById(R.id.edit_title);
		content = (EditText)findViewById(R.id.edit_content);
		latitude = (EditText)findViewById(R.id.edit_latitude);
		longitude = (EditText)findViewById(R.id.edit_longitude);
		picture = (ImageView)findViewById(R.id.edit_picture);
		commit = (ImageButton)findViewById(R.id.edit_commit);
		cancel = (ImageButton)findViewById(R.id.edit_cancel);

	}
	
	/**
	 *  Initialize View. Get ActionBar to enable title and disable title.
	 */
	private void initView() {
		// ActionBar
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comment_page, menu);
		return true;
	}

}