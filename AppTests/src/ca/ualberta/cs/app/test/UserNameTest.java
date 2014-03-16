/**
 * 
 */
package ca.ualberta.cs.app.test;

import activity.ResetUserNameActivity;
import android.test.ActivityInstrumentationTestCase2;
import com.example.projectapp.UserNameInfo;

/**
 * JUnit test cases for ResetUserName.
 * 
 * @author Yilu Su
 *
 */
public class UserNameTest extends ActivityInstrumentationTestCase2<ResetUserNameActivity> {

	/**
	 * Constructor
	 */
	public UserNameTest() {
		super(ResetUserNameActivity.class);
	}

	public void testUserName() {
		UserNameInfo info = new UserNameInfo();
		ResetUserNameActivity activity;
		info.setUserName("name");
	}
}
