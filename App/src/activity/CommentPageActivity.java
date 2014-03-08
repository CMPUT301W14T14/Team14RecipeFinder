package activity;

import network_io.IoStreamHandler;

import com.example.projectapp.R;
import com.example.projectapp.UserNameInfo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class CommentPageActivity extends Activity {

	//private Button sort=null;
	//private Button userInfo=null;
	private Button readLater=null;
	private Button edit=null;
	private Button like=null;
	private Button reply=null;
	
	private TextView commentText=null;
	private TextView authorInfo=null;
	
	private IoStreamHandler io=null;
	private String userName=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commentpage);
		//sort=(Button)findViewById(R.id.sort2);
		//userInfo=(Button)findViewById(R.id.userbutton2);
		readLater=(Button)findViewById(R.id.SaveForLater);
		edit=(Button)findViewById(R.id.edit);
		like=(Button)findViewById(R.id.Like);
		reply=(Button)findViewById(R.id.reply);
		commentText=(TextView)findViewById(R.id.commentText);
		authorInfo=(TextView)findViewById(R.id.authorInfo);
		io=new IoStreamHandler();
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		userName=((UserNameInfo)this.getApplication()).getUserName();
		Intent intent=getIntent();
		io.loadAndSetSpecificComment(intent.getStringExtra("comment_id"),commentText,authorInfo,this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comment_page, menu);
		return true;
	}

}
