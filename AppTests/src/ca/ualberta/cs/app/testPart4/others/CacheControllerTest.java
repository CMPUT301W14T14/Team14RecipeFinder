/**
 * 
 */
package ca.ualberta.cs.app.testPart4.others;

import cache.CacheController;
import model.Comment;
import model.CommentList;
import activity.AllTopicPageActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for CacheController.
 * 
 * @author Yilu Su
 *
 */
public class CacheControllerTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor 
	 */
	public CacheControllerTest() {
		super(AllTopicPageActivity.class);
	}
	
	/**
	 * Test whether the cacheController can locally saved and retrieved top level comments and replies using sharedPreference. <br>
	 * First, create a top level comment and a reply to it. Save both of them locally. Then retrieve them and check. <br>
	 * Methods tested: addCacheAsTopLevel, addCacheAsReply, getResource and getReply.
	 * @throws Exception 
	 */
	public void testCacheController() throws Exception {
		Comment comment1 = new Comment("Title1", "Content1", null, null, "User1");
		Comment comment2 = new Comment("Title2", "Content2", null, null, "User2");
		comment1.addReply(comment2);
		CacheController cacheController = new CacheController();
		cacheController.addCacheAsTopLevel(getActivity(), comment1, "fav");
		cacheController.addCacheAsReply(getActivity(), comment1.getId(), comment2);
		
		CommentList commentList1 = cacheController.getResource(getActivity(), "fav");
		CommentList commentList2 = cacheController.getReply(comment1.getId(), getActivity());
		assertTrue(commentList1.getCurrentList().contains(comment1));
		assertTrue(commentList2.getCurrentList().contains(comment2));
		
		tearDown();
	}

}
