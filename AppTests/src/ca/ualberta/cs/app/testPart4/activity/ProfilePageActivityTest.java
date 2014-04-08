package ca.ualberta.cs.app.testPart4.activity;

import user.UserNameHandler;
import activity.LoginViewActivity;
import activity.ProfilePageActivity;
import android.content.SharedPreferences;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Junit test cases for ProfilePageActivity.
 * @author yilu
 *
 */
public class ProfilePageActivityTest extends
		ActivityInstrumentationTestCase2<ProfilePageActivity> {
	
	ProfilePageActivity mActivity;
	EditText userName;
	EditText biography;
	EditText twitter;
	EditText facebook;
	ImageView photo;
	ImageButton commit;
	ImageButton cancel;

	/**
	 * Constructor 
	 */
	public ProfilePageActivityTest() {
		super(ProfilePageActivity.class);
	}

	/**
     * Sets up the test environment before each test.
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
	@Override
	public void setUp() throws Exception {
		super.setUp();

        setActivityInitialTouchMode(true);

        SharedPreferences caches=this.getInstrumentation().getTargetContext().getSharedPreferences("cachesKey",0);
		caches.edit().putString("userNameKey","user").commit();
        mActivity = getActivity();
        
        Thread.sleep(1000);
        
        userName = (EditText) mActivity.findViewById(com.example.projectapp.R.id.user_name);
        biography = (EditText) mActivity.findViewById(com.example.projectapp.R.id.biography);
        twitter = (EditText) mActivity.findViewById(com.example.projectapp.R.id.twitter);
        facebook = (EditText) mActivity.findViewById(com.example.projectapp.R.id.facebook);
        photo = (ImageView) mActivity.findViewById(com.example.projectapp.R.id.profile_picture);
        commit = (ImageButton) mActivity.findViewById(com.example.projectapp.R.id.commit_profile);
		cancel = (ImageButton) mActivity.findViewById(com.example.projectapp.R.id.cancel_profile);
	}
	
	/**
	 * Verify biography Layout Parameters
	 */
	@MediumTest
	public void testBiographyLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, biography);

	    final ViewGroup.LayoutParams layoutParams = biography.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify twitter Layout Parameters
	 */
	@MediumTest
	public void testTwitterNameLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, twitter);

	    final ViewGroup.LayoutParams layoutParams = twitter.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify Facebook Layout Parameters
	 */
	@MediumTest
	public void testFacebookNameLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, facebook);

	    final ViewGroup.LayoutParams layoutParams = facebook.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify photo Layout Parameters
	 */
	@MediumTest
	public void testPhotoLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, photo);

	    final ViewGroup.LayoutParams layoutParams = photo.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify UserName Layout Parameters
	 */
	@MediumTest
	public void testUserNameLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, userName);

	    final ViewGroup.LayoutParams layoutParams = userName.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify CommitButton Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testCommitLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, commit);

	    final ViewGroup.LayoutParams layoutParams = commit.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify CancelButton Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testCancleLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, cancel);

	    final ViewGroup.LayoutParams layoutParams = cancel.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
}
