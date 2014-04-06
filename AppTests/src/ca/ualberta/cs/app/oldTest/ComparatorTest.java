package ca.ualberta.cs.app.oldTest;
///**
// * 
// */
//package ca.ualberta.cs.app.testPart3;
//
//
//import comparator.TimeComparator;
//
//import model.Comment;
//import activity.HomePageActivity;
//import android.test.ActivityInstrumentationTestCase2;
//
///**
// * 
// * JUnit test cases for Comparators.
// * 
// * @author Yilu
// *
// */
//public class ComparatorTest extends ActivityInstrumentationTestCase2<HomePageActivity> {
//
//	/**
//	 * Constructor
//	 */
//	public ComparatorTest() {
//		super(HomePageActivity.class);
//	}
//	
//	/**
//	 * Test the timeComparator function
//	 * Create two comments with an interval of 200 milliseconds. 
//	 * Then, compare the timePosted of them using timeParator method
//	 */
//	public void testTimeComparator() {
//		Comment comment1 = new Comment("title1", "text1", null, "userName1");
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Comment comment2 = new Comment("title2", "text2", null, "userName2");
//		TimeComparator timeComparator = new TimeComparator();
//		assertEquals(0, timeComparator.compare(comment1, comment2));
//	}
//	
//	/**
//	 * Test the sortByProximity function
//	 */
//	public void testSortByProximity() {
//		fail("Not yet implemented");
//	}
//	
//	/**
//	 * Test the sortByPicture function
//	 */
//	public void testSortByPicture() {
//		fail("Not yet implemented");
//	}
//	
//	/**
//	 * Test the sortByDate function
//	 */
//	public void testSortByDate() {
//		fail("Not yet implemented");
//	}
//	
//	/**
//	 * Test the sortByScore function
//	 */
//	public void testSortByScore() {
//		fail("Not yet implemented");
//	}
//
//}
