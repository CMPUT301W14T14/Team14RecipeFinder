package ca.ualberta.cs.app.testPart4.activity;
import activity.OtherProfilePageActivity;
import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Junit
 * @author yilu
 *
 */
@SuppressLint("NewApi")
public class OtherProfilePageActivityTest extends
		ActivityInstrumentationTestCase2<OtherProfilePageActivity> {
	
	OtherProfilePageActivity mActivity;
	TextView userName;
	TextView biography;
	TextView twitter;
	TextView facebook;
	ImageView photo;

	public OtherProfilePageActivityTest() {
		super(OtherProfilePageActivity.class);
	}
	
	public void setUp() throws Exception {
		super.setUp();

        setActivityInitialTouchMode(true);

        mActivity = getActivity();
        
        userName = (TextView) mActivity.findViewById(com.example.projectapp.R.id.other_profile_user_name);
        biography = (TextView) mActivity.findViewById(com.example.projectapp.R.id.other_profile_biography);
        twitter = (TextView) mActivity.findViewById(com.example.projectapp.R.id.other_profile_twitter);
        facebook = (TextView) mActivity.findViewById(com.example.projectapp.R.id.other_profile_facebook);
        photo = (ImageView) mActivity.findViewById(com.example.projectapp.R.id.other_profile_picture);
        
        
        
        
	}

}
