package ca.ualberta.cs.app.testPart4.activity;

import activity.LoginViewActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * JUnit test cases for LoginViewActivity.
 * 
 * @author Yilu Su
 *
 */
public class LoginViewActivityTest extends ActivityInstrumentationTestCase2<LoginViewActivity> {

	LoginViewActivity mActivity;
	TextView mTextView;
	EditText mEditText;
	Button mButton;
	
	/**
	 * Constructor 
	 */
	public LoginViewActivityTest() {
		super(LoginViewActivity.class);
	}
	
	/**
     * Sets up the test environment before each test.
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
	@Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        mActivity = getActivity();
        mTextView = (TextView) mActivity.findViewById(com.example.projectapp.R.id.login_userName_input_ins);
        mEditText = (EditText) mActivity.findViewById(com.example.projectapp.R.id.user_name_input);
        mButton = (Button) mActivity.findViewById(com.example.projectapp.R.id.login_button);
    }
	
	/**
	 * Verify TextView Layout Parameters
	 */
	@MediumTest
	public void testTextViewLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mTextView);

	    final ViewGroup.LayoutParams layoutParams = mTextView.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify EditText Layout Parameters
	 */
	@MediumTest
	public void testEditTextLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mEditText);

	    final ViewGroup.LayoutParams layoutParams = mEditText.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify Button Layout Parameters
	 */
	@MediumTest
	public void testButtonLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mButton);

	    final ViewGroup.LayoutParams layoutParams = mButton.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}

}
