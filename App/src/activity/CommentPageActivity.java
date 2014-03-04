package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CommentPageActivity extends Activity {

	private Button sort = null;
	private Button userInfo = null;
	private Button readLater = null;
	private Button edit = null;
	private Button like = null;
	private Button reply = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commentpage);
		sort = (Button)findViewById(R.id.sort2);
		userInfo = (Button)findViewById(R.id.userinfo2);
		readLater = (Button)findViewById(R.id.SaveForLater);
		edit = (Button)findViewById(R.id.edit);
		like = (Button)findViewById(R.id.Like);
		reply = (Button)findViewById(R.id.reply);
	}

	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sort.setOnClickListener(listener);
		userInfo.setOnClickListener(listener);
		readLater.setOnClickListener(listener);
		edit.setOnClickListener(listener);
		like.setOnClickListener(listener);
		reply.setOnClickListener(listener);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comment_page, menu);
		return true;
	}
	
	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button = (Button)v;
			switch (button.getId()){
			case R.id.sort2:
				// sort Button click
				
				break;
			case R.id.userinfo2:
				// user info Button click
				
				break;
			case R.id.SaveForLater:
				// read later Button click
				
				break;
			case R.id.edit:
				// edit Button click
				
				break;
			case R.id.Like:
				// like it Button click
				
				break;
			case R.id.reply:
				// reply Button click
				
				break;
			}
		}
	};

}
