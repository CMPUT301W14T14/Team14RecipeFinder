package ca.ualberta.cs.app.testPart4;

import java.util.Date;

import model.Comment;
import model.CommentMap;
import network_io.IoStreamHandler;
import activity.CommentPageActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * JUnit test cases for Comment model.
 * 
 * @author Yilu Su
 *
 */
public class CommentPageActivityTest extends ActivityInstrumentationTestCase2<CommentPageActivity> {
	
//	Instrumentation instrumentation;
//	Activity activity;

	/**
	 * Constructor 
	 */
	public CommentPageActivityTest() {
		super(CommentPageActivity.class);
	}
	
	/**
	 * Test whether a comment can be pulled from the server and displayed in views used in CommentPageActivity <br>
	 * Update a comment to the server. Then run the method and check content of the views in CommentPageActivity. <br>
	 * Methods tested: addOrUpdateComment and loadAndSetSpecificComment.
	 * @throws InterruptedException 
	 */
	public void testLoadAndSetSpecificComment() throws InterruptedException {
		Location location = new Location("mock");
		location.setLatitude(10);
		location.setLongitude(20);
		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		Intent intent = new Intent();
		setActivityIntent(intent);
		Comment comment = new Comment("Title", "Content", location, pic, "User");
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		Thread thread = new Thread();
		TextView title = (TextView)getActivity().findViewById(com.example.projectapp.R.id.comment_title);
		TextView content = (TextView)getActivity().findViewById(com.example.projectapp.R.id.comment_content);
		TextView commentInfo = (TextView)getActivity().findViewById(com.example.projectapp.R.id.comment_info);
		ImageView picture = (ImageView)getActivity().findViewById(com.example.projectapp.R.id.topic_image);
		CommentMap commentMap = new CommentMap();
		
		thread = ioStreamHandler.addOrUpdateComment(comment);
		thread.join();
		thread = ioStreamHandler.loadAndSetSpecificComment(comment.getId(), title, content, commentInfo, picture, commentMap, getActivity());
		thread.join();
		Thread.sleep(1000);
		
		String lat=String.valueOf(location.getLatitude());
		String lng=String.valueOf(location.getLongitude());
		String info = "Posted By : "+comment.getUserName()+"\nAt : "+((new Date(comment.getTimePosted())).toString())+"\nLongitude: "+lng+"\nLatitude: "+lat; 
		assertEquals("Title", title.getText());
		assertEquals("Content", content.getText());
		assertNotNull(picture.getDrawable());
		assertEquals(info, commentInfo.getText());
		ioStreamHandler.clean();
		Thread.sleep(500);
	}
	
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		instrumentation = getInstrumentation();
//		activity = getActivity();
//	}
	
//	/**
//	 * Test whether a comment can be pulled from the server and displayed in views used in EditCommentPageActivity <br>
//	 * Update a comment to the server. Then run the method and check content of the views in EditCommentPageActivity. <br>
//	 * Methods tested: addOrUpdateComment and loadAndSetSpecificComment.
//	 * @throws InterruptedException 
//	 */
//	@UiThreadTest
//	public void testSetupEditPage() throws InterruptedException {
//		Location location = new Location("mock");
//		location.setLatitude(10);
//		location.setLongitude(20);
//		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
//		Comment comment = new Comment("Title", "Content", location, pic, "User");
//		IoStreamHandler ioStreamHandler = new IoStreamHandler();
//		Thread thread = new Thread();
//		thread = ioStreamHandler.addOrUpdateComment(comment);
//		thread.join();
//		Thread.sleep(1000);
//		
//		Intent intent = new Intent();
//		setActivityIntent(intent);
//		
//		CommentPageActivity activity = getActivity();
//		
//		Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(EditCommentPageActivity.class.getName(), null, false);
//		
//		ImageButton imageButton = (ImageButton) activity.findViewById(com.example.projectapp.R.id.comment_edit);
//		boolean click = imageButton.performClick();
//		assertTrue(click);
//		
//		
//		
//		
//		final EditCommentPageActivity editCommentPageActivity = (EditCommentPageActivity) getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
//		
//		assertNotNull(editCommentPageActivity);
//		
//		EditText title = (EditText) editCommentPageActivity.findViewById(com.example.projectapp.R.id.edit_title);
//		EditText content = (EditText) editCommentPageActivity.findViewById(com.example.projectapp.R.id.edit_content);
//		EditText latitude = (EditText) editCommentPageActivity.findViewById(com.example.projectapp.R.id.edit_latitude);
//		EditText longitude = (EditText) editCommentPageActivity.findViewById(com.example.projectapp.R.id.edit_longitude);
//		ImageView picture = (ImageView) editCommentPageActivity.findViewById(com.example.projectapp.R.id.edit_picture);
////		CommentMap commentMap = new CommentMap();
//		
//		
//		thread = ioStreamHandler.setupEditPage(comment.getId(), title, content, latitude, longitude, picture, editCommentPageActivity);
//		thread.join();
//		Thread.sleep(1000);
//		
////		String lat=String.valueOf(location.getLatitude());
////		String lng=String.valueOf(location.getLongitude());
//		
//		assertEquals("Title", title.getText());
//		assertEquals("Content", content.getText());
//		assertEquals(String.valueOf(location.getLatitude()), latitude.getEditableText().toString());
//		assertEquals(String.valueOf(location.getLongitude()), longitude.getEditableText().toString());
//		assertNotNull(picture.getDrawable());
//		ioStreamHandler.clean();
//		Thread.sleep(500);
//	}
	
	

}
