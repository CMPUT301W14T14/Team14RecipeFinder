/**
 * 
 */
package ca.ualberta.cs.app.test;

import activity.ResetUserNameActivity;
import android.test.ActivityInstrumentationTestCase2;
import com.example.projectapp.UserNameInfo;

/**
 * JUnit test cases for UserName.
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

	/**
	 * Test whether the userName can be retrieved and reset
	 */
	public void testUserName() {
		UserNameInfo userNameInfo = new UserNameInfo();
		userNameInfo.setUserName("Name");
		assertEquals("Name", userNameInfo.getUserName());
		userNameInfo.setUserName("NewName");
		assertEquals("NewName", userNameInfo.getUserName());
	}
}
