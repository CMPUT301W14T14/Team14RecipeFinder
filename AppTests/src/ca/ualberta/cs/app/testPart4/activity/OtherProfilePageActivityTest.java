package ca.ualberta.cs.app.testPart4.activity;
import activity.OtherProfilePageActivity;
import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Junit test cases for OtherProfilePageActivity.
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

	/**
	 * Constructor 
	 */
	public OtherProfilePageActivityTest() {
		super(OtherProfilePageActivity.class);
	}
	
	/**
     * Sets up the test environment before each test.
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
	@Override
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

}
