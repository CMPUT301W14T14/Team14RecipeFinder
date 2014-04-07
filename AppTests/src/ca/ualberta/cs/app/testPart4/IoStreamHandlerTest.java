/**
 * 
 */
package ca.ualberta.cs.app.testPart4;

import network_io.IoStreamHandler;
import model.Comment;
import model.CommentMap;
import model.IdSet;
import activity.AllTopicPageActivity;
import activity.CommentPageActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.projectapp.*;

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
//		ioStreamHandler.clean();
//		Thread.sleep(500);
	}

//	public void testLoadSpecificComment() {
//		fail("Not yet implemented");
//	}
	
//	/**
//	 * Test whether a top level IdSet can be pushed to the server and the pulled from the serve later. <br>
//	 * Update two comment and add them to the top level IdSet. Then load the top level comments and check. <br>
//	 * Methods tested: updateTopLevelIdSet and loadTopLevelComments.
//	 * @throws InterruptedException 
//	 */
//	public void testUpdateTopLevelIdSet() throws InterruptedException {
//		Comment comment1 = new Comment("Title1", "Content1", null, null, "User1");
//		Comment comment2 = new Comment("Title2", "Content2", null, null, "User2");
//		IdSet idSet = new IdSet();
//		idSet.add(comment1.getId());
//		idSet.add(comment2.getId());
//		IoStreamHandler ioStreamHandler = new IoStreamHandler();
//		CommentMap commentMap = new CommentMap();
//		Thread thread = new Thread();
//		
//		thread = ioStreamHandler.addOrUpdateComment(comment1);
//		thread.join();
//		thread = ioStreamHandler.addOrUpdateComment(comment2);
//		thread.join();
//		thread = ioStreamHandler.updateTopLevelIdSet(idSet);
//		thread.join();
//		thread = ioStreamHandler.loadTopLevelComments(commentMap, getActivity());
//		thread.join();
//		Thread.sleep(1000);
//		assertEquals(comment1, commentMap.getComment(comment1.getId()));
//		assertEquals(comment2, commentMap.getComment(comment2.getId()));
////		ioStreamHandler.clean();
////		Thread.sleep(500);
//	}
	
//	public void testLoadTopLevelComments() {
//		fail("Not yet implemented");
//	}

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
//		ioStreamHandler.clean();
//		Thread.sleep(500);
	}

	/**
	 * Test whether a comment can be pulled from the server and displayed in views used in CommentPageActivity <br>
	 * Update a comment to the server. Then run the method and check content of the views. <br>
	 * Methods tested: addOrUpdateComment and loadAndSetSpecificComment.
	 * @throws InterruptedException 
	 */
	public void testLoadAndSetSpecificComment() throws InterruptedException {
		Intent intent = new Intent();
		setActivityIntent(intent);
		Comment comment = new Comment("Title", "Content", null, null, "User");
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		Thread thread = new Thread();
		CommentPageActivity commentPageActivity = new CommentPageActivity();
//		commentPageActivity.refresh();
//		Activity activity = getActivity();
		TextView title = (TextView)getActivity().findViewById(com.example.projectapp.R.id.comment_title);
		TextView content = (TextView)getActivity().findViewById(com.example.projectapp.R.id.comment_content);
		TextView commentInfo = (TextView)getActivity().findViewById(com.example.projectapp.R.id.comment_info);
		ImageView picture = (ImageView)getActivity().findViewById(com.example.projectapp.R.id.topic_image);
		CommentMap commentMap = new CommentMap();
		
		thread = ioStreamHandler.addOrUpdateComment(comment);
		thread.join();
		thread = ioStreamHandler.loadAndSetSpecificComment(comment.getId(), title, content, commentInfo, picture, commentMap, commentPageActivity);
		thread.join();
		Thread.sleep(1000);
		
//		String title1 = title.getEditableText().toString();
		assertEquals("Title", title.getText());
		
	}

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
