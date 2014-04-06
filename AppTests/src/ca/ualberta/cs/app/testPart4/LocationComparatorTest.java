/**
 * 
 */
package ca.ualberta.cs.app.testPart4;

import comparator.LocationComparator;
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
public class LocationComparatorTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor 
	 */
	public LocationComparatorTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether the compare method returns the correct value. <br>
	 * First, create two comments and a locationComparator with a center location.
	 * Then, check if the compare method returns the correct value when comments with 
	 * different location are passed in.
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
		LocationComparator locationComparator = new LocationComparator(location0);
		
		Comment comment1 = new Comment("title1", "content1", null, null, "userName1");
		Comment comment2 = new Comment("title2", "content2", null, null, "userName2");
		assertEquals(0, locationComparator.compare(comment1, comment2));
		
		comment1.setLocation(location1);
		assertEquals(-1, locationComparator.compare(comment1, comment2));
		assertEquals(1, locationComparator.compare(comment2, comment1));
		
		comment2.setLocation(location2);
		assertEquals(-1, locationComparator.compare(comment1, comment2));
		assertEquals(1, locationComparator.compare(comment2, comment1));
	}

}
