package activity;

import network_io.IoStreamHandler;
import user.UserNameHandler;

import com.example.projectapp.R;

import activity.CreateCommentPageActivity.AttachClick;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfilePageActivity extends Activity {
	public static final int OBTAIN_PIC_REQUEST_CODE=252;
	
	private TextView userTitle = null;
	
	private EditText userName = null;
	private EditText biography = null;
	private EditText twitter = null;
	private EditText facebook = null;
	private ImageButton profilePicture = null;
	private ImageButton commitProfile=null;
	private ImageButton cancelProfile=null;
	
	private IoStreamHandler profileIo=null;
	private UserNameHandler profileUserNameHandler=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_page);
		
		userName = (EditText)findViewById(R.id.user_name);
		biography = (EditText)findViewById(R.id.biography);
		twitter = (EditText)findViewById(R.id.twitter);
		facebook = (EditText)findViewById(R.id.facebook);
		profilePicture = (ImageButton)findViewById(R.id.profile_picture);
		commitProfile = (ImageButton)findViewById(R.id.commit_profile);
		cancelProfile = (ImageButton)findViewById(R.id.cancel_profile);
		userTitle = (TextView)findViewById(R.id.profile_title);
		
		profileIo=new IoStreamHandler();
		profileUserNameHandler=new UserNameHandler();
		
		profilePicture.setOnClickListener(new ProfileAttachClick());
		cancelProfile.setOnClickListener(new ProfileCancelClick());
		commitProfile.setOnClickListener(new ProfileCommitClick());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile_page, menu);
		return true;
	}
	
	/**
	 * Direct user to camera in order to take the attached photo.
	 */
	public void profileTakeAPhoto(){
		Intent camIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(camIntent,OBTAIN_PIC_REQUEST_CODE);
	}
	
	class ProfileAttachClick implements OnClickListener{
        @Override
		public void onClick(View v){
        	profileTakeAPhoto();
		}
	}

	class ProfileCancelClick implements OnClickListener{
        @Override
		public void onClick(View v){
        	finish();
		}
	}
	
	class ProfileCommitClick implements OnClickListener{
        @Override
		public void onClick(View v){
        	String userProfileName=userName.getText().toString();
        	String profileBiography=biography.getText().toString();
        	String profileTwitter=twitter.getText().toString();
        	String profileFacebook=facebook.getText().toString();
        	

        	finish();
		}
	}
}
