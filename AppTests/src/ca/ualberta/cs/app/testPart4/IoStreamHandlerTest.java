/**
 * 
 */
package ca.ualberta.cs.app.testPart4;

import cache.CacheController;
import network_io.IoStreamHandler;
import model.Comment;
import model.CommentList;
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
	 * Test whether a comment can be pushed to the server and the pulled from the serve later. <br>
	 * Create a comment and update to the server. Then load it and check. <br>
	 * Methods tested: addOrUpdateComment and loadSpecificComment.
	 * @throws InterruptedException 
	 */
	public void testAddOrUpdateComment() throws InterruptedException {
		Location location = new Location("mock");
		location.setLatitude(10);
		location.setLongitude(10);
		Bitmap picture = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		Comment comment = new Comment("Title", "Content", location, picture, "User");
		CommentMap commentMap = new CommentMap();
		Thread thread = new Thread();
		
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		thread = ioStreamHandler.addOrUpdateComment(comment);
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
		ioStreamHandler.clean();
		Thread.sleep(500);
	}
	
	/**
	 * Test whether a top level IdSet can be pushed to the server and the pulled from the serve later. <br>
	 * Update two comment and add them to the top level IdSet. Then load the top level comments and check. <br>
	 * Methods tested: updateTopLevelIdSet and loadTopLevelComments.
	 * @throws InterruptedException 
	 */
	public void testUpdateTopLevelIdSet() throws InterruptedException {
		Comment comment1 = new Comment("Title1", "Content1", null, null, "User1");
		Comment comment2 = new Comment("Title2", "Content2", null, null, "User2");
		IdSet idSet = new IdSet();
		idSet.add(comment1.getId());
		idSet.add(comment2.getId());
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		CommentMap commentMap = new CommentMap();
		Thread thread = new Thread();
		
		thread = ioStreamHandler.addOrUpdateComment(comment1);
		thread.join();
		thread = ioStreamHandler.addOrUpdateComment(comment2);
		thread.join();
		thread = ioStreamHandler.updateTopLevelIdSet(idSet);
		thread.join();
		thread = ioStreamHandler.loadTopLevelComments(commentMap, getActivity());
		thread.join();
		Thread.sleep(1000);
		assertEquals(comment1, commentMap.getComment(comment1.getId()));
		assertEquals(comment2, commentMap.getComment(comment2.getId()));
		ioStreamHandler.clean();
		Thread.sleep(500);
	}

	/**
	 * Test whether a comment can be pushed to the server as top level comment and the pulled from the serve later. <br>
	 * Update a comment as top level comment. Then load top level IdSet and check if the IdSet contains the comment. <br>
	 * Methods tested: loadAndUpdateTopLevelIdSet and loadTopLevelComments.
	 * @throws InterruptedException 
	 */
	public void testLoadAndUpdateTopLevelIdSet() throws InterruptedException {
		Comment comment = new Comment("Title", "Content", null, null, "User");
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		CommentMap commentMap = new CommentMap();
		Thread thread = new Thread();

		thread = ioStreamHandler.loadAndUpdateTopLevelIdSet(comment.getId(), getActivity());
		thread.join();
		thread = ioStreamHandler.addOrUpdateComment(comment);
		thread.join();
		thread = ioStreamHandler.loadTopLevelComments(commentMap, getActivity());
		thread.join();
		Thread.sleep(1000);
		
		assertEquals(comment, commentMap.getComment(comment.getId()));
		ioStreamHandler.clean();
		Thread.sleep(500);
	}

	/**
	 * Test whether a reply can be added to the reply IdSet of a comment that is in the server. <br>
	 * First, use the method to load the comment from the serve and add a reply to its reply IdSet. 
	 * Then load the comment and check.
	 * Methods tested: replySpecificComment
	 * @throws InterruptedException 
	 */
	public void testReplySpecificComment() throws InterruptedException {
		Comment comment1 = new Comment("Title1", "Content1", null, null, "User1");
		Comment comment2 = new Comment("Title2", "Content2", null, null, "User2");
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		CommentMap commentMap = new CommentMap();
		Thread thread = new Thread();
		
		thread = ioStreamHandler.addOrUpdateComment(comment1);
		thread.join();
		thread = ioStreamHandler.addOrUpdateComment(comment2);
		thread.join();
		thread = ioStreamHandler.replySpecificComment(comment1.getId(), comment2.getId());
		thread.join();
		thread = ioStreamHandler.loadSpecificComment(comment1.getId(), commentMap, getActivity());
		thread.join();
		Thread.sleep(1000);
		
		assertTrue(commentMap.getComment(comment1.getId()).getReplies().contains(comment2.getId()));
		ioStreamHandler.clean();
		Thread.sleep(500);
	}

	/**
	 * @throws InterruptedException 
	 */
	public void testCommitEdit() throws InterruptedException {
		Comment comment = new Comment("Title", "Content", null, null, "User");
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		CommentMap commentMap = new CommentMap();
		Thread thread = new Thread();
		Location location = new Location("mock");
		location.setLatitude(10);
		location.setLongitude(10);
		String newTitle = "new Title";
		String newContent = "new Content";
		
		thread = ioStreamHandler.addOrUpdateComment(comment);
		thread.join();
		thread = ioStreamHandler.commitEdit(comment.getId(), newTitle, newContent, location);
		thread.join();
		thread = ioStreamHandler.loadSpecificComment(comment.getId(), commentMap, getActivity());
		thread.join();
		Thread.sleep(1000);
		
		assertEquals(newTitle, commentMap.getComment(comment.getId()).getTitle());
		assertEquals(newContent, commentMap.getComment(comment.getId()).getText());
		assertEquals(location.getLatitude(), commentMap.getComment(comment.getId()).getLocation().getLatitude());
		assertEquals(location.getLongitude(), commentMap.getComment(comment.getId()).getLocation().getLongitude());
		ioStreamHandler.clean();
		Thread.sleep(500);
	}

	/**
	 * @throws InterruptedException 
	 * 
	 */
	public void testAddCache() throws InterruptedException {
		Comment comment1 = new Comment("Title1", "Content1", null, null, "User1");
		Comment comment2 = new Comment("Title2", "Content2", null, null, "User2");
		comment1.addReply(comment2);
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		CacheController cacheController = new CacheController();
		Thread thread = new Thread();
		
		thread = ioStreamHandler.addOrUpdateComment(comment1);
		thread.join();
		thread = ioStreamHandler.addOrUpdateComment(comment2);
		thread.join();
		thread = ioStreamHandler.addCache(comment1.getId(), null, cacheController, "fav", getActivity());
		thread.join();
		thread = ioStreamHandler.addCache(comment1.getId(), null, cacheController, "indicated", getActivity());
		thread.join();
		Thread.sleep(2000);
		CommentList commentList1 = new CommentList();
		commentList1 = cacheController.getResource(getActivity(),"fav");
		assertTrue(commentList1.getCurrentList().contains(comment1));
		assertTrue(commentList1.getCurrentList().get(0).getReplies().contains(comment2));
		
		CommentList commentList2 = new CommentList();
		commentList2 = cacheController.getResource(getActivity(),"indicated");
		assertTrue(commentList2.getCurrentList().contains(comment1));
		assertTrue(commentList2.getCurrentList().get(0).getReplies().contains(comment2));
		ioStreamHandler.clean();
		Thread.sleep(500);
	}

//	public void testClean() {
//		fail("Not yet implemented");
//	}

}
