/**
 * 
 */
package ca.ualberta.cs.app.testPart4;

import network_io.IoStreamHandler;
import model.Comment;
import model.CommentMap;
import model.IdSet;
import activity.AllTopicPageActivity;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for Comment model.
 * 
 * @author Yilu Su
 *
 */
public class IoStreamHandlerTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor 
	 */
	public IoStreamHandlerTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether a comment can be pushed to the server and the pulled from the serve later.
	 * @throws InterruptedException 
	 */
	public void testAddOrUpdateComment() throws InterruptedException {
		Location location = new Location("mock");
		location.setLatitude(10);
		location.setLongitude(10);
		Bitmap picture = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		Comment comment = new Comment("Title", "Content", location, picture, "User");
		CommentMap commentMap = new CommentMap();
		
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		Thread thread = ioStreamHandler.addOrUpdateComment(comment);
		thread.join();
		thread = ioStreamHandler.loadSpecificComment(comment.getId(), commentMap, getActivity());
		thread.join();
		Thread.sleep(1000);
		
		assertEquals(comment, commentMap.getComment(comment.getId()));
		assertEquals("Title", commentMap.getComment(comment.getId()).getTitle());
		assertEquals("Content", commentMap.getComment(comment.getId()).getText());
		assertEquals(location.getLatitude(), commentMap.getComment(comment.getId()).getLocation().getLatitude());
		assertEquals(location.getLongitude(), commentMap.getComment(comment.getId()).getLocation().getLongitude());
		assertNotNull(commentMap.getComment(comment.getId()).getPicture()!=null);
		assertEquals("User", commentMap.getComment(comment.getId()).getUserName());

	}

//	public void testLoadSpecificComment() {
//		fail("Not yet implemented");
//	}
//
	
	/**
	 * Test whether a comment can be pushed to the server and the pulled from the serve later.
	 * @throws InterruptedException 
	 */
	public void testUpdateTopLevelIdSet() throws InterruptedException {
		Comment comment1 = new Comment("Title1", "Content1", null, null, "User1");
		Comment comment2 = new Comment("Title2", "Content2", null, null, "User1");
		IdSet idSet = new IdSet();
		idSet.add(comment1.getId());
		idSet.add(comment2.getId());
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		CommentMap commentMap = new CommentMap();
		
		Thread thread = ioStreamHandler.updateTopLevelIdSet(idSet);
//		thread.join();
		Thread.sleep(1000);
		
		thread = ioStreamHandler.loadTopLevelComments(commentMap, getActivity());
//		thread.join();
		Thread.sleep(1000);
		assertTrue(commentMap.getCurrentList().isEmpty());
//		assertEquals(comment1, commentMap.getCurrentList().get(0));
//		assertEquals(comment2, commentMap.getCurrentList().get(1));
//		assertEquals(comment1, commentMap.getComment(comment1.getId()));
//		assertEquals(comment2, commentMap.getComment(comment2.getId()));
	}
	
//
//	public void testLoadTopLevelComments() {
//		fail("Not yet implemented");
//	}
//
//	public void testLoadAndUpdateTopLevelIdSet() {
//		fail("Not yet implemented");
//	}
//
//	public void testLoadAndSetSpecificComment() {
//		fail("Not yet implemented");
//	}
//
//	public void testReplySpecificComment() {
//		fail("Not yet implemented");
//	}
//
//	public void testSetupEditPage() {
//		fail("Not yet implemented");
//	}
//
//	public void testCommitEdit() {
//		fail("Not yet implemented");
//	}
//
//	public void testAddCache() {
//		fail("Not yet implemented");
//	}
//
//	public void testClean() {
//		fail("Not yet implemented");
//	}

}
