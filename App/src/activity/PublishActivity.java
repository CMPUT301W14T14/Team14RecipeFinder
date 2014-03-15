package activity;

import network_io.IoStreamHandler;
import gps.Location_Generator;
import model.Comment;

import com.example.projectapp.R;
import com.example.projectapp.UserNameInfo;

import android.location.LocationManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PublishActivity extends Activity {
	public static final int OBTAIN_PIC_REQUEST_CODE=252;
	
	private EditText title=null;
	private EditText content=null;
	private Button attach_pic=null;
	private Button commit=null;
	private Button cancel=null;
	
	private IoStreamHandler io=null;
	
	private String userName=null;
	private Bitmap attached_pic=null;
	private Location_Generator location_generator=null;
	private boolean isTopLevel;
	private ImageView preview=null;

	private String comment_id=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.publish);
		title=(EditText)findViewById(R.id.topictitle);
		content=(EditText)findViewById(R.id.typecontent);
		preview=(ImageView)findViewById(R.id.imagePreview);
		preview.setImageBitmap(null);
		attach_pic=(Button)findViewById(R.id.attach);
		commit=(Button)findViewById(R.id.commitPublish);
		cancel=(Button)findViewById(R.id.cancelPublish);
		
		io=new IoStreamHandler();
		
		Intent intent=getIntent();
		isTopLevel=intent.getBooleanExtra("isTopLevel",false);
	}
	

	@Override
	protected void onResume(){
		super.onResume();
		cancel.setOnClickListener(new CancelClick());
		commit.setOnClickListener(new CommitClick());
		attach_pic.setOnClickListener(new AttachClick());
		location_generator=new Location_Generator((LocationManager)getSystemService(Context.LOCATION_SERVICE));
		userName=((UserNameInfo)this.getApplication()).getUserName();
		Intent intent=getIntent();
		comment_id=intent.getStringExtra("comment_id");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.publish, menu);
		return true;
	}
	
	//Function related to photo:
	/**
	 * Direct user to camera in order to take the attached photo.
	 */
	public void takeAPhoto(){
		Intent cam_intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cam_intent, OBTAIN_PIC_REQUEST_CODE);
	}
	/**
	 * Set the image preview if the photo has been taken.
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == OBTAIN_PIC_REQUEST_CODE && resultCode == RESULT_OK) {
			attached_pic = (Bitmap)data.getExtras().get("data");
			preview.setImageBitmap(attached_pic);
		}
	}	
	//--------------------------------------------------------------
	
	public void updateTopIdSet(Comment comment){
		io.load_update_TopLevelIdSet(comment.getId(),this);
	}
	/**
	 * This click listener finishes the current activity.
	 * @author xuping
	 */
	class CancelClick implements OnClickListener{
        @Override
		public void onClick(View v){
        	finish();
		}
	}
	/**
	 * This click listener creates a new comment and commit it to the server,if this comment is a top level comment,add its id to the topLevelIdSet.Otherwise add its id to the comment it replies to.
	 * @author xuping
	 */
	class CommitClick implements OnClickListener{
        @Override
		public void onClick(View v){
			String commentTitle=title.getText().toString();
			String commentContent=content.getText().toString();
			if(commentTitle.length()>=20){
				Toast.makeText(getApplicationContext(),"Title cannot longer than 20 characters.",Toast.LENGTH_SHORT).show();
			}
			else{
				Comment comment=null;
				if(attached_pic==null){
					comment=new Comment(commentTitle,commentContent,location_generator.getCurrentLocation(),userName);
				}
				else{
					comment=new Comment(commentTitle,commentContent,location_generator.getCurrentLocation(),attached_pic,userName);
				}
				
				if(isTopLevel){
					updateTopIdSet(comment);
				}
				else if(comment_id!=null){
					io.replySpecificComment(comment_id,comment.getId());
				}
				io.commitUpdateComment(comment);
				attached_pic=null;
				finish();
			}
		}
		
	}
	
	class AttachClick implements OnClickListener{
        @Override
		public void onClick(View v){
        	takeAPhoto();
		}
	}
}
