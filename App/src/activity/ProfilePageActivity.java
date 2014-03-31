package activity;

import user.UserNameHandler;
import model.UserProfile;
import network_io.ConnectionChecker;
import network_io.ProfileIoHandler;

import com.example.projectapp.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePageActivity extends Activity {
	
	private TextView profileTitle;
	private ImageButton photo;
	private EditText userNameInput;
	private EditText biographyInput;
	private EditText twitterInput;
	private EditText facebookInput;
	private ImageButton cancel;
	private ImageButton commit;
	
	private ProfileIoHandler profileIoHandler=null;
	private UserNameHandler userNameHandler=null;
	
	private ConnectionChecker connectionChecker=null;
	
	public static final int OBTAIN_PIC_REQUEST_CODE=252;
	
	private Bitmap profilePhoto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_page);
		
		profileTitle=(TextView)findViewById(R.id.profile_title);
		photo=(ImageButton)findViewById(R.id.profile_picture);
		userNameInput=(EditText)findViewById(R.id.user_name);
		biographyInput=(EditText)findViewById(R.id.biography);
		twitterInput=(EditText)findViewById(R.id.twitter);
		facebookInput=(EditText)findViewById(R.id.facebook);
		
		cancel=(ImageButton)findViewById(R.id.cancel_profile);
		commit=(ImageButton)findViewById(R.id.commit_profile);
		
		profileIoHandler=new ProfileIoHandler();
		userNameHandler=new UserNameHandler();
		
		connectionChecker=new ConnectionChecker();
		
		profileTitle.setText("User Profile: ");
		if(connectionChecker.isNetworkOnline(this)){
			profileIoHandler.loadSpecificProfileForUpdate(userNameHandler.getUserName(this),this, photo, userNameInput, biographyInput, twitterInput, facebookInput);
		}
		else{
			Toast.makeText(getApplicationContext(),"Offline.",Toast.LENGTH_SHORT).show();
		}
		
		photo.setOnClickListener(new AttachPhotoClick());
		cancel.setOnClickListener(new CancelClick());
		commit.setOnClickListener(new UpdateProfileClick());
	}
	
	public void takeAPhoto(){
		Intent camIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(camIntent,OBTAIN_PIC_REQUEST_CODE);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == OBTAIN_PIC_REQUEST_CODE && resultCode == RESULT_OK) {
			profilePhoto = (Bitmap)data.getExtras().get("data");
			photo.setImageBitmap(profilePhoto);
		}
	}
	
	class AttachPhotoClick implements OnClickListener{

		@Override
		public void onClick(View v){
			takeAPhoto();
		}
		
	}
	
	class UpdateProfileClick implements OnClickListener{

		@Override
		public void onClick(View v){
			UserProfile newProfile=new UserProfile(userNameInput.getText().toString(),biographyInput.getText().toString(),
					twitterInput.getText().toString(),facebookInput.getText().toString(),profilePhoto);
			if(connectionChecker.isNetworkOnline(ProfilePageActivity.this)){
				profileIoHandler.putOrUpdateProfile(newProfile);
				finish();
			}
			else{
				Toast.makeText(getApplicationContext(),"Offline.",Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	class CancelClick implements OnClickListener{

		@Override
		public void onClick(View v){
			finish();
		}
		
	}
	
}
