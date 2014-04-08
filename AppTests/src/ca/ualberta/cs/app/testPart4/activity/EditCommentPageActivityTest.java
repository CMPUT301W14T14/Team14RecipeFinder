/**
 * 
 */
package ca.ualberta.cs.app.testPart4.activity;

import activity.EditCommentPageActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
	
	EditCommentPageActivity mActivity;
	EditText title;
	EditText content;
	EditText latitude;
	EditText longitude;
	ImageView picture;
	ImageButton commit;
	ImageButton cancel;

	/**
	 * Constructor 
	 */
	public EditCommentPageActivityTest() {
		super(EditCommentPageActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();

        setActivityInitialTouchMode(true);

        mActivity = getActivity();
        
		title = (EditText)this.getActivity().findViewById(com.example.projectapp.R.id.edit_title);
		content = (EditText)this.getActivity().findViewById(com.example.projectapp.R.id.edit_content);
		latitude = (EditText)this.getActivity().findViewById(com.example.projectapp.R.id.edit_latitude);
		longitude = (EditText)this.getActivity().findViewById(com.example.projectapp.R.id.edit_longitude);
		picture = (ImageView)this.getActivity().findViewById(com.example.projectapp.R.id.edit_picture);
	}
	
	/**
	 * Verify Title Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testTitleLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, title);

	    final ViewGroup.LayoutParams layoutParams = title.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify Content Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testContentLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, content);

	    final ViewGroup.LayoutParams layoutParams = content.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify Picture Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testPictureLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, picture);

	    final ViewGroup.LayoutParams layoutParams = picture.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify Latitude Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testLatitudeLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, latitude);

	    final ViewGroup.LayoutParams layoutParams = latitude.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify Longitude Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testLongitudeLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, longitude);

	    final ViewGroup.LayoutParams layoutParams = longitude.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify CommitButton Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testCommitLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, commit);

	    final ViewGroup.LayoutParams layoutParams = commit.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify CancelButton Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testCancleLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, cancel);

	    final ViewGroup.LayoutParams layoutParams = cancel.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	
	
	
//	/**
//	 * Test whether a comment can be pulled from the server and displayed in views used in EditCommentPageActivity <br>
//	 * Update a comment to the server. Then run the method and check content of the views in EditCommentPageActivity. <br>
//	 * Methods tested: addOrUpdateComment and loadAndSetSpecificComment.
//	 * @throws InterruptedException 
//	 */
//	public void testSetupEditPage() throws InterruptedException {
//		Comment comment = new Comment("Title", "Content", null, null, "User");
//		IoStreamHandler ioStreamHandler = new IoStreamHandler();
//		Thread thread = new Thread();
//		
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
//		assertNotNull(picture.getDrawable());
//		ioStreamHandler.clean();
//		Thread.sleep(500);
//	}

}
