package ca.ualberta.cs.app.testPart4.activity;

import model.UserProfile;
import network_io.ProfileIoHandler;
import activity.AllTopicPageActivity;
import activity.CommentPageActivity;
import activity.CreateCommentPageActivity;
import activity.EditCommentPageActivity;
import activity.FavoritePageActivity;
import activity.LocalCommentPageActivity;
import activity.LoginViewActivity;
import activity.OtherProfilePageActivity;
import activity.ProfilePageActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Junit
 * @author yilu
 *
 */
@SuppressLint("NewApi")
public class OtherProfilePageActivityUITest extends
		ActivityInstrumentationTestCase2<OtherProfilePageActivity> {
	
	Instrumentation instrumentation;
	Activity activity;
	TextView userName;
	TextView biography;
	TextView twitter;
	TextView facebook;
	ImageView photo;

	public OtherProfilePageActivityUITest() {
		super(OtherProfilePageActivity.class);
	}
	
	public void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();
	}
	
	
	
	
	
	
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		instrumentation = getInstrumentation();
		
//		Intent intent = new Intent();
//		setActivityIntent(intent);
//		activity = getActivity();
		
//		UserProfile profile = new UserProfile("userName", "biography", "twitter", "facebook", null);
//		ProfileIoHandler profileHandler = new ProfileIoHandler();
//		Thread thread = new Thread();	
//		thread = profileHandler.putOrUpdateProfile(profile);
		
		
//		photo=(ImageView) activity.findViewById(com.example.projectapp.R.id.other_profile_picture);
		
//	}
	
//	public void testPutOrUpdateProfile() throws InterruptedException {
//		Thread.sleep(1000);

//				Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
//				UserProfile profile = new UserProfile("userName", "biography", "twitter", "facebook", null);
//				ProfileIoHandler profileHandler = new ProfileIoHandler();
//				Thread thread = new Thread();
				
//				userName=(TextView) getActivity().findViewById(com.example.projectapp.R.id.other_profile_user_name);
//				biography=(TextView) getActivity().findViewById(com.example.projectapp.R.id.other_profile_biography);
//				twitter=(TextView) getActivity().findViewById(com.example.projectapp.R.id.other_profile_twitter);
//				facebook=(TextView) getActivity().findViewById(com.example.projectapp.R.id.other_profile_facebook);
				
//				thread = profileHandler.putOrUpdateProfile(profile);
//				thread.join();
//				Thread.sleep(5000);
//				ProfileIoHandler profileHandler2 = new ProfileIoHandler();
//				assertNotNull(profile.getUserName());
				
//				ImageView photo=(ImageView) activity.findViewById(com.example.projectapp.R.id.other_profile_picture);
//				TextView userName=(TextView) activity.findViewById(com.example.projectapp.R.id.other_profile_user_name);
//				TextView biography=(TextView) activity.findViewById(com.example.projectapp.R.id.other_profile_biography);
//				TextView twitter=(TextView) activity.findViewById(com.example.projectapp.R.id.other_profile_twitter);
//				TextView facebook=(TextView) activity.findViewById(com.example.projectapp.R.id.other_profile_facebook);
				
				
//				profileHandler.loadSpecificProfileForView("userName", getActivity(), photo, userName, biography, twitter, facebook); 
//				thread.join();

//				Thread.sleep(1000);
//
//				
//				assertEquals("userName", userName.getText());
//				assertEquals("biography", biography.getText());
//				assertEquals("twitter", twitter.getText());
//				assertEquals("facebook", facebook.getText());
//				assertNotNull(photo.getDrawable());
				
//				IoStreamHandler ioStreamHandler = new IoStreamHandler();
//				ioStreamHandler.clean();
//				Thread.sleep(500);
			

		
//	}
	
	
	
	

}
