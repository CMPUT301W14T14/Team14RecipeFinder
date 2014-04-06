/**
 * 
 */
package ca.ualberta.cs.app.testPart4;
import comparator.ScoreSystem;
import model.Comment;
import activity.AllTopicPageActivity;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for LocationComparator.
 * 
 * @author Yilu Su
 *
 */
public class ScoreSystemTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor 
	 */
	public ScoreSystemTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether the compare method returns the correct value. <br>
	 * First, create two comments and a scoreSystem with a center location.
	 * Then, check if the compare method returns the correct value when comments with 
	 * different scores are passed in.
	 */
	public void testCompare() {
		Location location0 = new Location("mock");
		location0.setLatitude(0);
		location0.setLongitude(0);
		Location location1 = new Location("mock");
		location1.setLatitude(10);
		location1.setLongitude(10);
		Location location2 = new Location("mock");
		location2.setLatitude(100);
		location2.setLongitude(100);
		ScoreSystem scoreSystem = new ScoreSystem(location0);
		Comment comment2 = new Comment("title2", "content2", location2, null, "userName2");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Comment comment1 = new Comment("title1", "content1", location1, null, "userName1");
		
		assertEquals(-1, scoreSystem.compare(comment1, comment2));
		assertEquals(1, scoreSystem.compare(comment2, comment1));
	}

}
