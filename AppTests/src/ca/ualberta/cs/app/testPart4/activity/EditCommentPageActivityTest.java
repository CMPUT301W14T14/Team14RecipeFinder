package ca.ualberta.cs.app.testPart4.activity;

//import model.Comment;
//import network_io.IoStreamHandler;
import java.util.Date;

import network_io.IoStreamHandler;
import model.Comment;
import model.CommentMap;
import activity.CommentPageActivity;
import activity.EditCommentPageActivity;
//import android.app.Activity;
//import android.app.Instrumentation;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.location.Location;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
//import android.widget.EditText;
//import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * JUnit test cases for EditCommentPageActivity.
 * 
 * @author Yilu Su
 *
 */
public class EditCommentPageActivityTest extends
		ActivityInstrumentationTestCase2<EditCommentPageActivity> {
	
	private Comment comment;
	private Thread thread;
	private IoStreamHandler ioStreamHandler;
	private Location location;

	/**
	 * Constructor 
	 */
	public EditCommentPageActivityTest() {
		super(EditCommentPageActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		ioStreamHandler = new IoStreamHandler();
		thread = new Thread();
		location = new Location("mock");
		location.setLatitude(10);
		location.setLongitude(20);
		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		comment = new Comment("Title", "Content", location, null, "User");
		thread = ioStreamHandler.addOrUpdateComment(comment);
		thread.join();
		Thread.sleep(500);
		
		Intent intent = new Intent();
		intent.putExtra("CommentId", comment.getId());
		setActivityIntent(intent);
	}
	
	/**
	 * Test whether a comment can be pulled from the server and displayed in views used in CommentPageActivity <br>
	 * Update a comment to the server. Then run the method and check content of the views in CommentPageActivity. <br>
	 * Methods tested: addOrUpdateComment and loadAndSetSpecificComment.
	 * @throws InterruptedException 
	 */
	@UiThreadTest
	public void testSetupEditPage() throws InterruptedException {
		
		EditText title = (EditText) getActivity().findViewById(com.example.projectapp.R.id.edit_title);
		EditText content = (EditText) getActivity().findViewById(com.example.projectapp.R.id.edit_content);
		EditText latitude = (EditText) getActivity().findViewById(com.example.projectapp.R.id.edit_latitude);
		EditText longitude = (EditText) getActivity().findViewById(com.example.projectapp.R.id.edit_longitude);
		ImageView picture = (ImageView) getActivity().findViewById(com.example.projectapp.R.id.edit_picture);
		
		
		thread = ioStreamHandler.setupEditPage(comment.getId(), title, content, latitude, longitude, picture, getActivity());
		thread.join();
		Thread.sleep(1000);
		
		assertEquals("Title", title.getText());
		assertEquals("Content", content.getText());
		assertEquals(String.valueOf(location.getLatitude()), latitude.getEditableText().toString());
		assertEquals(String.valueOf(location.getLongitude()), longitude.getEditableText().toString());
		assertNotNull(picture.getDrawable());
		ioStreamHandler.clean();
		Thread.sleep(500);
		
		getActivity().finish();
		
//		String lat=String.valueOf(location.getLatitude());
//		String lng=String.valueOf(location.getLongitude());
//		String info = "Posted By : "+comment.getUserName()+"\nAt : "+((new Date(comment.getTimePosted())).toString())+"\nLongitude: "+lng+"\nLatitude: "+lat; 
//		assertEquals("Title", title.getText());
//		assertEquals("Content", content.getText());
//		assertNotNull(picture.getDrawable());
//		assertEquals(info, commentInfo.getText());
////		ioStreamHandler.clean();
//		Thread.sleep(500);
		
		
	}
	
	
	
	
//	/**
//	 * Test whether a comment can be pulled from the server and displayed in views used in EditCommentPageActivity <br>
//	 * Update a comment to the server. Then run the method and check content of the views in EditCommentPageActivity. <br>
//	 * Methods tested: addOrUpdateComment and loadAndSetSpecificComment.
//	 * @throws InterruptedException 
//	 */
//	public void testSetupEditPage() throws InterruptedException {
////		Location location = new Location("mock");
////		location.setLatitude(10);
////		location.setLongitude(20);
////		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
////		Comment comment = new Comment("Title", "Content", location, pic, "User");
//		Comment comment = new Comment("Title", "Content", null, null, "User");
//		IoStreamHandler ioStreamHandler = new IoStreamHandler();
//		Thread thread = new Thread();
//		
//		
//		
//		assertTrue("ahahahahahahahahahahahaha!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", true);
//		EditText title = (EditText)this.getActivity().findViewById(com.example.projectapp.R.id.edit_title);
//		EditText content = (EditText)this.getActivity().findViewById(com.example.projectapp.R.id.edit_content);
//		EditText latitude = (EditText)this.getActivity().findViewById(com.example.projectapp.R.id.edit_latitude);
//		EditText longitude = (EditText)this.getActivity().findViewById(com.example.projectapp.R.id.edit_longitude);
//		ImageView picture = (ImageView)this.getActivity().findViewById(com.example.projectapp.R.id.edit_picture);
//		
//		thread = ioStreamHandler.addOrUpdateComment(comment);
//		thread.join();
//		Thread.sleep(1000);
//		thread = ioStreamHandler.setupEditPage(comment.getId(), title, content, latitude, longitude, picture, this.getActivity());
//		thread.join();
//		Thread.sleep(1000);
//		
//		assertEquals("Title", title.getText());
//		assertEquals("Content", content.getText());
////		assertEquals(String.valueOf(location.getLatitude()), latitude.getEditableText().toString());
////		assertEquals(String.valueOf(location.getLongitude()), longitude.getEditableText().toString());
//		assertNotNull(picture.getDrawable());
//		ioStreamHandler.clean();
//		Thread.sleep(500);
//	}


}
