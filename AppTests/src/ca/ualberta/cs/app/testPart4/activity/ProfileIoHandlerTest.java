/**
 * 
 */
package ca.ualberta.cs.app.testPart4.activity;

import network_io.IoStreamHandler;
import network_io.ProfileIoHandler;
import model.UserProfile;
import activity.OtherProfilePageActivity;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * JUnit test cases for ProfileIoHandler.
 * 
 * @author Yilu Su
 *
 */
@SuppressLint("NewApi")
public class ProfileIoHandlerTest extends ActivityInstrumentationTestCase2<OtherProfilePageActivity> {

	/**
	 * Constructor 
	 */
	public ProfileIoHandlerTest() {
		super(OtherProfilePageActivity.class);
	}

	/**
	 * Test whether a profile can be updated to the server and retrieved and displayed. <br>
	 * First, create a profile and update to the server. Then load it from the server check.
	 * Methods tested: putOrUpdateProfile and loadSpecificProfileForView
	 * @throws InterruptedException
	 */
	public void testPutOrUpdateProfile() throws InterruptedException {
//		Thread.sleep(1000);
		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		UserProfile profile = new UserProfile("userName", "biography", "twitter", "facebook", pic);
		ProfileIoHandler profileHandler = new ProfileIoHandler();
		Thread thread = new Thread();
		ImageView photo=(ImageView)getActivity().findViewById(com.example.projectapp.R.id.other_profile_picture);
		TextView userName=(TextView)getActivity().findViewById(com.example.projectapp.R.id.other_profile_user_name);
		TextView biography=(TextView)getActivity().findViewById(com.example.projectapp.R.id.other_profile_biography);
		TextView twitter=(TextView)getActivity().findViewById(com.example.projectapp.R.id.other_profile_twitter);
		TextView facebook=(TextView)getActivity().findViewById(com.example.projectapp.R.id.other_profile_facebook);
		
		thread = profileHandler.putOrUpdateProfile(profile);
		thread.join();
		Thread.sleep(5000);
		ProfileIoHandler profileHandler2 = new ProfileIoHandler();
		assertNull(profile.getUserName());
		thread = profileHandler2.loadSpecificProfileForView(profile.getUserName(), getActivity(), photo, userName, biography, twitter, facebook); 
		thread.join();
		Thread.sleep(1000);
		
		assertEquals("userName", userName.getText());
		assertEquals("biography", biography.getText());
		assertEquals("twitter", twitter.getText());
		assertEquals("facebook", facebook.getText());
		assertNotNull(photo.getDrawable());
		
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		ioStreamHandler.clean();
		Thread.sleep(500);
	}

}
