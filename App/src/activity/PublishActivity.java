package activity;

import java.util.ArrayList;

import network_io.IoStreamHandler;
import gps.Location_Generator;
import model.Comment;
import model.User;

import com.example.projectapp.R;
import com.google.gson.Gson;

import customlized_gson.Gson_Constructor;

import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PublishActivity extends Activity {
	private EditText title=null;
	private EditText content=null;
	private Button attach_pic=null;
	private Button commit=null;
	private Button cancel=null;
	
	private IoStreamHandler io=null;
	
	private Gson gson=(new Gson_Constructor()).getGson();
	private User currentUser=null;
	private Bitmap attached_pic=null;
	private Location_Generator location_generator=null;
	private boolean isTopLevel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.publish);
		title=(EditText)findViewById(R.id.topictitle);
		content=(EditText)findViewById(R.id.typecontent);
		attach_pic=(Button)findViewById(R.id.attach);
		commit=(Button)findViewById(R.id.commitPublish);
		cancel=(Button)findViewById(R.id.cancelPublish);
		
		io=new IoStreamHandler();
		
		Intent intent=getIntent();
		currentUser=gson.fromJson(intent.getStringExtra("user"),User.class);
		isTopLevel=intent.getBooleanExtra("isTopLevel",false);
	}
	

	@Override
	protected void onResume(){
		super.onResume();
		cancel.setOnClickListener(new CancelClick());
		location_generator=new Location_Generator((LocationManager)getSystemService(Context.LOCATION_SERVICE));
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.publish, menu);
		return true;
	}
	
	public ArrayList<String> getIdSet(){
		ArrayList<String> idSet=new ArrayList<String>();
		io.loadTopLevelIdSet(idSet,this);
		return idSet;
	}
	
	class CancelClick implements OnClickListener{
        @Override
		public void onClick(View v){
        	finish();
		}
	}
	
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
					comment=new Comment(commentTitle,commentContent,location_generator.getCurrentLocation(),currentUser.getUserName());
				}
				else{
					comment=new Comment(commentTitle,commentContent,location_generator.getCurrentLocation(),attached_pic,currentUser.getUserName());
				}
				
				if(isTopLevel){
					ArrayList<String> idSet=getIdSet();
					idSet.add(comment.getId());
					io.updateTopLevelIdSet(idSet);
				}
				io.commitUpdateComment(comment);
			}
		}
		
	}
}
