package ca.ualberta.cs.app.testPart4.activity;

import model.UserProfile;
import network_io.IoStreamHandler;
import network_io.ProfileIoHandler;
import activity.ProfilePageActivity;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ImageButton;

public class ProfilePageActivityTest extends
		ActivityInstrumentationTestCase2<ProfilePageActivity> {

	public ProfilePageActivityTest() {
		super(ProfilePageActivity.class);
	}

	/**
	 * Test whether a profile can be updated to the server and retrieved and displayed. <br>
	 * First, create a profile and update to the server. Then load it from the server check.
	 * Methods tested: putOrUpdateProfile and loadSpecificProfileForView
	 * @throws InterruptedException
	 */
//	public void testLoadSpecificProfileForUpdate() throws InterruptedException {
//		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
//		UserProfile profile = new UserProfile("userName2", "biography", "twitter", "facebook", null);
//		ProfileIoHandler profileHandler = new ProfileIoHandler();
//		Thread thread = new Thread();
//		ImageButton photo=(ImageButton)getActivity().findViewById(com.example.projectapp.R.id.profile_picture);
//		EditText userName=(EditText)getActivity().findViewById(com.example.projectapp.R.id.user_name);
//		EditText biography=(EditText)getActivity().findViewById(com.example.projectapp.R.id.biography);
//		EditText twitter=(EditText)getActivity().findViewById(com.example.projectapp.R.id.twitter);
//		EditText facebook=(EditText)getActivity().findViewById(com.example.projectapp.R.id.facebook);
//		userName.setText("userName");
//		biography.setText("new biography");
//		twitter.setText("new twitter");
//		facebook.setText("new facebook");
//		photo.setImageBitmap(pic);
//		
//		thread = profileHandler.putOrUpdateProfile(profile);
//		thread.join();
//		thread = profileHandler.loadSpecificProfileForUpdate("userName", getActivity(), photo, userName, biography, twitter, facebook); 
//		thread.join();
//		Thread.sleep(1000);
//		
//		assertEquals("userName", userName.getText());
//		assertEquals("new biography", biography.getText());
//		assertEquals("new twitter", twitter.getText());
//		assertEquals("new facebook", facebook.getText());
//		assertNotNull(photo.getDrawable());
//		
//		IoStreamHandler ioStreamHandler = new IoStreamHandler();
//		ioStreamHandler.clean();
//		Thread.sleep(500);
//	}
}
