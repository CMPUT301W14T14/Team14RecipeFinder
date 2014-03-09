package activity;

import network_io.IoStreamHandler;

import com.example.projectapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class EditPageActivity extends Activity{
	
	private EditText title=null;
	private EditText content=null;
	private ImageView pic=null;
	private Button commit=null;
	private Button cancel=null;
	private IoStreamHandler io=null;
	private String comment_id=null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.publish);
		
		title=(EditText)findViewById(R.id.topictitle);
		content=(EditText)findViewById(R.id.typecontent);
		pic=(ImageView)findViewById(R.id.imagePreview);
		pic.setImageBitmap(null);
		commit=(Button)findViewById(R.id.commitPublish);
		cancel=(Button)findViewById(R.id.cancelPublish);
		
		io=new IoStreamHandler();
		Intent intent=getIntent();
		comment_id=intent.getStringExtra("comment_id");
	}

	@Override
	protected void onResume(){
		super.onResume();
		io.set_up_edit_page(comment_id,title,content,pic,this);
		commit.setOnClickListener(new CommitEditClick());
		cancel.setOnClickListener(new CancelClick());
	}
	
	class CommitEditClick implements OnClickListener{

		@Override
		public void onClick(View v){
			String newTitle=title.getText().toString();
			String newContent=content.getText().toString();
			io.commit_edit_comment(comment_id, newTitle, newContent);
			finish();
		}
		
	}
	
	class CancelClick implements OnClickListener{
        @Override
		public void onClick(View v){
        	finish();
		}
	}
}
