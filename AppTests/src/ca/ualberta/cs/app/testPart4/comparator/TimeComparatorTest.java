/**
 * 
 */
package ca.ualberta.cs.app.testPart4.comparator;
import comparator.TimeComparator;

import model.Comment;
import activity.AllTopicPageActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for TimeComparator.
 * 
 * @author Yilu Su
 *
 */
public class TimeComparatorTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor 
	 */
	public TimeComparatorTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether the compare method returns the correct value. <br>
	 * First, create two comments and a timeComparator with a center location.
	 * Then, check if the compare method returns the correct value when comments created 
	 * at different time are passed in.
	 */
	public void testCompare() {
		TimeComparator timeComparator = new TimeComparator();
		Comment comment2 = new Comment("title2", "content2", null, null, "userName2");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Comment comment1 = new Comment("title1", "content1", null, null, "userName1");
		
		assertEquals(-1, timeComparator.compare(comment1, comment2));
		assertEquals(1, timeComparator.compare(comment2, comment1));
	}

}
