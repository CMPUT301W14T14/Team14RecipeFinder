package ca.ualberta.cs.app.testPart4;

import model.Comment;
import network_io.IoStreamHandler;
import activity.EditCommentPageActivity;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * JUnit test cases for Comment model.
 * 
 * @author Yilu Su
 *
 */
public class EditCommentPageActivityTest extends
		ActivityInstrumentationTestCase2<EditCommentPageActivity> {
	
//	Instrumentation instrumentation;
//	Activity activity;

	/**
	 * Constructor 
	 */
	public EditCommentPageActivityTest() {
		super(EditCommentPageActivity.class);
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
