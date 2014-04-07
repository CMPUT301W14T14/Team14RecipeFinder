/**
 * 
 */
package ca.ualberta.cs.app.testPart4.comparator;

import comparator.PictureComparator;
import model.Comment;
import activity.AllTopicPageActivity;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for PictureComparator.
 * 
 * @author Yilu Su
 *
 */
public class PictureComparatorTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor 
	 */
	public PictureComparatorTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether the compare method returns the correct value. <br>
	 * First, create two comments and a pictureComparator.
	 * Then, check if the compare method returns the correct value when comments with 
	 * or without a picture are passed in.
	 */
	public void testCompare() {
		PictureComparator pictureComparator = new PictureComparator();
		Bitmap pic1 = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		Bitmap pic2 = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		Comment comment1 = new Comment("title1", "content1", null, null, "userName1");
		Comment comment2 = new Comment("title2", "content2", null, null, "userName2");
		Comment comment3 = new Comment("title3", "content3", null, pic1, "userName3");
		Comment comment4 = new Comment("title4", "content4", null, pic2, "userName4");
		
		assertEquals(0, pictureComparator.compare(comment1, comment2));
		assertEquals(0, pictureComparator.compare(comment3, comment4));
		assertEquals(-1, pictureComparator.compare(comment3, comment1));
		assertEquals(1, pictureComparator.compare(comment2, comment4));
	}

}
