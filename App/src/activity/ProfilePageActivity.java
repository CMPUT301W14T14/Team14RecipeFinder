package activity;

import user.UserNameHandler;
import network_io.ProfileIoHandler;

import com.example.projectapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfilePageActivity extends Activity {
	
	private TextView profileTitle;
	private ImageButton photo;
	private EditText userNameInput;
	private EditText biographyInput;
	private EditText twitterInput;
	private EditText facebookInput;
	private Button cancel;
	private Button commit;
	
	private ProfileIoHandler profileIoHandler=null;
	private UserNameHandler userNameHandler=null;
	
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
		
		cancel=(Button)findViewById(R.id.cancel_profile);
		commit=(Button)findViewById(R.id.commit_profile);
		
		profileIoHandler=new ProfileIoHandler();
		userNameHandler=new UserNameHandler();
		
		profileTitle.setText("User Profile: ");
		profileIoHandler.loadSpecificProfileForUpdate(userNameHandler.getUserName(this),this, photo, userNameInput, biographyInput, twitterInput, facebookInput);
	}
	
}
