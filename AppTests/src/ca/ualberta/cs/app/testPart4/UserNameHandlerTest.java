/**
 * 
 */
package ca.ualberta.cs.app.testPart4;

import user.UserNameHandler;
import activity.LoginViewActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for LocationComparator.
 * 
 * @author Yilu Su
 *
 */
public class UserNameHandlerTest extends ActivityInstrumentationTestCase2<LoginViewActivity> {

	/**
	 * Constructor 
	 */
	public UserNameHandlerTest() {
		super(LoginViewActivity.class);
	}

	/**
	 * Test whether the string for user name can be saved, retrieved 
	 * and edited using sharedPreference. <br>
	 * First, set a user name and check it. 
     * Then, clear the user name and check it again.
	 */
	public void testUserNameHandler() {
		UserNameHandler userNameHandler = new UserNameHandler();
		String userName = "user name";
		
		userNameHandler.setUserName(getActivity(), userName);
		assertEquals("user name", userNameHandler.getUserName(getActivity()));
		
		userNameHandler.emptyUserName(getActivity());
		assertEquals(null, userNameHandler.getUserName(getActivity()));
	}

}
