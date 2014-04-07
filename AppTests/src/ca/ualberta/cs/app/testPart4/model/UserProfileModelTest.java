/**
 * 
 */
package ca.ualberta.cs.app.testPart4.model;

import model.UserProfile;
import activity.AllTopicPageActivity;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for UserProfile model.
 * 
 * @author Yilu Su
 *
 */
public class UserProfileModelTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor 
	 */
	public UserProfileModelTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether the user name of a profile can be retrieved and edited. <br>
	 * First, create a profile and check if the user name retrieved by getUserName method is correct. 
	 * Then, use the setUserName method to change the user name and check if the new user name is correct. <br>
	 * Methods tested: getName and setName.
	 */
	public void testGetAndSetUserName() {
		UserProfile profile = new UserProfile("userName", "biography", "twitter", "facebook", null);
		assertEquals("userName", profile.getUserName());
		
		profile.setUserName("new userName");
		assertEquals("new userName", profile.getUserName());
	}

	/**
	 * Test whether the biography of a profile can be retrieved and edited. <br>
	 * First, create a profile and check if the biography retrieved by getBiography method is correct. 
	 * Then, use the setBiography method to change the user biography check if the new biography is correct. <br>
	 * Methods tested: getBiography and setBiography.
	 */
	public void testGetAndSetBiography() {
		UserProfile profile = new UserProfile("userName", "biography", "twitter", "facebook", null);
		assertEquals("biography", profile.getBiography());
		
		profile.setBiography("new biography");
		assertEquals("new biography", profile.getBiography());
	}

	/**
	 * Test whether the twitter of a profile can be retrieved and edited. <br>
	 * First, create a profile and check if the twitter retrieved by getTwitter method is correct. 
	 * Then, use the setTwitter method to change the twitter and check if the new twitter is correct. <br>
	 * Methods tested: getTwitter and setTwitter.
	 */
	public void testGetAndSetTwitter() {
		UserProfile profile = new UserProfile("userName", "biography", "twitter", "facebook", null);
		assertEquals("twitter", profile.getTwitter());
		
		profile.setTwitter("new twitter");
		assertEquals("new twitter", profile.getTwitter());
	}

	/**
	 * Test whether the facebook of a profile can be retrieved and edited. <br>
	 * First, create a profile and check if the facebook retrieved by getFacebook method is correct. 
	 * Then, use the setFacebook method to change the facebook and check if the new facebook is correct. <br>
	 * Methods tested: getFacebook and setFacebook.
	 */
	public void testGetAndSetFacebook() {
		UserProfile profile = new UserProfile("userName", "biography", "twitter", "facebook", null);
		assertEquals("facebook", profile.getFacebook());
		
		profile.setFacebook("new facebook");
		assertEquals("new facebook", profile.getFacebook());
	}

	/**
	 * Test whether the photo of a profile can be retrieved and edited. <br>
	 * First, create a profile and check if the photo retrieved by getPhoto method is correct. 
	 * Then, use the setPhoto method to change the photo and check if the new photo is correct. <br>
	 * Methods tested: getPhoto and setPhoto.
	 */
	public void testGetAndSetPhoto() {
		UserProfile profile = new UserProfile("userName", "biography", "twitter", "facebook", null);
		assertEquals(null, profile.getPhoto());
		
		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		profile.setPhoto(pic);
		assertEquals(pic, profile.getPhoto());
	}

}
