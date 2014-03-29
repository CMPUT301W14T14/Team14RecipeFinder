package activity;

import gps.LocationGenerator;
import network_io.ConnectionChecker;
import network_io.IoStreamHandler;

import com.example.projectapp.R;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class EditCommentPageActivity extends Activity {
	
	private EditText title=null;
	private EditText content=null;
	private EditText latitude=null;
	private EditText longitude=null;
	private ImageView picture=null;
	private ImageButton commit=null;
	private ImageButton cancel=null;
	
	private String commentID=null;
	private IoStreamHandler io=null;
	private LocationGenerator locationGenerator=null;

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
		
		Intent intent=getIntent();
		commentID=intent.getStringExtra("commentID");
		
		io=new IoStreamHandler();
		locationGenerator=new LocationGenerator((LocationManager)getSystemService(Context.LOCATION_SERVICE));
		io.setupEditPage(commentID,title,content,latitude,longitude,picture,this);
		
		cancel.setOnClickListener(new CancelClick());
		commit.setOnClickListener(new CommitEditClick());
		
	}
	
	class CancelClick implements OnClickListener{
        @Override
		public void onClick(View v){
        	finish();
		}
	}
	
	class CommitEditClick implements OnClickListener{

		@Override
		public void onClick(View v){
			ConnectionChecker connectionChecker=new ConnectionChecker();
			if(connectionChecker.isNetworkOnline(EditCommentPageActivity.this)==false){
				Toast.makeText(getApplicationContext(),"Offline.",Toast.LENGTH_SHORT).show();
				return;
			}
			String editedTitle=title.getText().toString();
			String editedText=content.getText().toString();
			Location location=null;
			String latString=latitude.getText().toString();
			String lngString=longitude.getText().toString();
			if(latString.trim().length()==0 && lngString.trim().length()==0){
				io.commitEdit(commentID, editedTitle, editedText, location, EditCommentPageActivity.this);
				try{
					Thread.sleep(500);
				} 
				catch (InterruptedException e){
					e.printStackTrace();
				}
				finish();
			}
			else{
				try{
					double lat=Double.parseDouble(latitude.getText().toString());
					double lng=Double.parseDouble(longitude.getText().toString());
					location=locationGenerator.getCustomLocation(lat,lng);
				}
				catch(Exception e){
					Toast.makeText(getApplicationContext(),"Invalid Input for location.",Toast.LENGTH_SHORT).show();
				}
				if(location==null){
					Toast.makeText(getApplicationContext(),"Error, location can not set.",Toast.LENGTH_SHORT).show();
				}
				else{
					io.commitEdit(commentID, editedTitle, editedText, location, EditCommentPageActivity.this);
					try{
						Thread.sleep(500);
					} 
					catch (InterruptedException e){
						e.printStackTrace();
					}
					finish();
				}
			}
		}
		
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