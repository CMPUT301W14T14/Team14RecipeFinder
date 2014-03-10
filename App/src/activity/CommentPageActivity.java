package activity;

import model.Comment;
import model.CommentMap;
import network_io.IoStreamHandler;

import com.example.projectapp.R;
import com.example.projectapp.UserNameInfo;

import adapter.ListViewAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CommentPageActivity extends Activity {

	//private Button sort=null;
	private Button userInfo=null;
	//private Button readLater=null;
	private Button edit=null;
	//private Button like=null;
	private Button reply=null;
	private Button sync=null;
	
	private TextView commentText=null;
	private TextView authorInfo=null;
	private ImageView pic=null;
	private ListView commentList=null;
	
	private IoStreamHandler io=null;
	
	private String userName=null;
	private String comment_id=null;
	
	private ListViewAdapter lva=null;
	private CommentMap cm=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commentpage);
		userName=((UserNameInfo)this.getApplication()).getUserName();
		//sort=(Button)findViewById(R.id.sort2);
		userInfo=(Button)findViewById(R.id.userbutton2);
		//readLater=(Button)findViewById(R.id.SaveForLater);
		edit=(Button)findViewById(R.id.edit);
		//like=(Button)findViewById(R.id.Like);
		reply=(Button)findViewById(R.id.reply);
		sync=(Button)findViewById(R.id.sync);
		commentText=(TextView)findViewById(R.id.commentText);
		authorInfo=(TextView)findViewById(R.id.authorInfo);
		pic=(ImageView)findViewById(R.id.topicImage);
		pic.setImageBitmap(null);
		commentList=(ListView)findViewById(R.id.commentList);
		io=new IoStreamHandler();
		
		cm=new CommentMap();
		lva=new ListViewAdapter(this,R.layout.single_comment_layout,cm.getCurrentList());
		commentList.setAdapter(lva);
		cm.setArrayAdapter(lva);
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		userName=((UserNameInfo)this.getApplication()).getUserName();
		Intent intent=getIntent();
		comment_id=intent.getStringExtra("comment_id");
		this.sync();
		
		reply.setOnClickListener(new ReplyClick());
		sync.setOnClickListener(new SyncClick());
		commentList.setOnItemClickListener(new RecurViewClick());
		edit.setOnClickListener(new EditClick());
		userInfo.setOnClickListener(new UserInfoClick());
	}
	
	protected void sync(){
		cm.clear();
		io.loadAndSetSpecificComment(comment_id,commentText,authorInfo,pic,cm,this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comment_page, menu);
		return true;
	}
	
	class ReplyClick implements OnClickListener{

		@Override
		public void onClick(View v){
			if(userName==null){
				Toast.makeText(getApplicationContext(),"Guest cannot reply comment.",Toast.LENGTH_SHORT).show();
			}
			else{
				Intent reply_intent=new Intent(CommentPageActivity.this,PublishActivity.class);
				reply_intent.putExtra("comment_id",comment_id);
				startActivity(reply_intent);
			}
		}
		
	}
	
	class SyncClick implements OnClickListener{

		@Override
		public void onClick(View v){
			sync();
		}
		
	}
	
	class RecurViewClick implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3){
			Comment c=(Comment)arg0.getItemAtPosition(pos);
			Intent view_intent=new Intent(CommentPageActivity.this,CommentPageActivity.class);
			view_intent.putExtra("comment_id",c.getId());
			startActivity(view_intent);
		}
		
	}
	
	class EditClick implements OnClickListener{

		@Override
		public void onClick(View v){
			if(userName==null){
				Toast.makeText(getApplicationContext(),"Guest cannot edit comment.",Toast.LENGTH_SHORT).show();
			}
			else{
				io.checkEditSpecificComment(comment_id, userName,CommentPageActivity.this);
			}
		}
		
	}
	
	class UserInfoClick implements OnClickListener{
		@Override
		public void onClick(View v){
			Intent push_intent=new Intent(CommentPageActivity.this,UserInfoPageActivity.class);
			startActivity(push_intent);
		}
	}

}
