package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CreateCommentPageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_comment_page);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.create_comment_page, menu);
		return true;
	}

}
