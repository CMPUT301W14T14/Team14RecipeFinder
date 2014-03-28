package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateCommentPageActivity extends Activity {
	
	private TextView title=null;
	private TextView content=null;
	private ImageButton picture=null;
	private ImageButton commit=null;
	private ImageButton cancel=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_comment_page);
		
		title = (TextView)findViewById(R.id.create_title);
		content = (TextView)findViewById(R.id.create_content);
		picture = (ImageButton)findViewById(R.id.create_image_review);
		commit = (ImageButton)findViewById(R.id.create_commit);
		cancel = (ImageButton)findViewById(R.id.create_cancel);
		
		// Initialize View
		initView();
	}

	/**
	 *  Initialize View. Change the title of the ActionBar
	 */
	private void initView() {
		// ActionBar
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.create_comment_page, menu);
		return true;
	}

}
