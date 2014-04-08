/**
 * 
 */
package ca.ualberta.cs.app.testPart4.activity;

import java.util.Date;
import model.Comment;
import model.CommentMap;
import network_io.IoStreamHandler;
import activity.CommentPageActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * JUnit test cases for CommentPageActivity.
 * 
 * @author Yilu Su
 *
 */
public class CommentPageActivityTest extends ActivityInstrumentationTestCase2<CommentPageActivity> {
	
	CommentPageActivity mActivity;
	Comment comment;
	Thread thread;
	IoStreamHandler ioStreamHandler;
	Location location;
	TextView title;
	TextView content;
	TextView commentInfo;
	ImageView picture;
	ImageButton profile;
	ImageButton like;
	ImageButton bookmark;
	ImageButton edit;
	Spinner mSpinner;
	ListView mListView;

	/**
	 * Constructor 
	 */
	public CommentPageActivityTest() {
		super(CommentPageActivity.class);
	}
	
	/**
     * Sets up the test environment before each test.
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(true);
		
		ioStreamHandler = new IoStreamHandler();
		thread = new Thread();
		location = new Location("mock");
		location.setLatitude(10);
		location.setLongitude(20);
		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		comment = new Comment("Title", "Content", location, pic, "User");
		thread = ioStreamHandler.addOrUpdateComment(comment);
		thread.join();
		Thread.sleep(500);
		
		Intent intent = new Intent();
		intent.putExtra("commentId", comment.getId());
		setActivityIntent(intent);
		
		mActivity = getActivity();
		title = (TextView)mActivity.findViewById(com.example.projectapp.R.id.comment_title);
		content = (TextView)mActivity.findViewById(com.example.projectapp.R.id.comment_content);
		commentInfo = (TextView)mActivity.findViewById(com.example.projectapp.R.id.comment_info);
		picture = (ImageView)mActivity.findViewById(com.example.projectapp.R.id.topic_image);
		profile = (ImageButton)mActivity.findViewById(com.example.projectapp.R.id.view_other_profile);
		like = (ImageButton)mActivity.findViewById(com.example.projectapp.R.id.comment_like);
		bookmark = (ImageButton)mActivity.findViewById(com.example.projectapp.R.id.comment_bookmark);
		edit = (ImageButton)mActivity.findViewById(com.example.projectapp.R.id.comment_edit);
		mSpinner = (Spinner) mActivity.findViewById(com.example.projectapp.R.id.comment_spinner);
        mListView = (ListView) mActivity.findViewById(com.example.projectapp.R.id.reply_list);
	}
	
	/**
	 * Test whether a comment can be pulled from the server and displayed in views used in CommentPageActivity <br>
	 * Update a comment to the server. Then run the method and check content of the views in CommentPageActivity. <br>
	 * Methods tested: addOrUpdateComment and loadAndSetSpecificComment.
	 * @throws Exception 
	 */
	public void testLoadAndSetSpecificComment() throws Exception {
		CommentMap commentMap = new CommentMap();
		thread = ioStreamHandler.loadAndSetSpecificComment(comment.getId(), title, content, commentInfo, picture, commentMap, mActivity);
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
		
		tearDown();
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
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
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
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify CommentInfo Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testCommentInfoLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, commentInfo);

	    final ViewGroup.LayoutParams layoutParams = commentInfo.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
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
	 * Verify ViewOtherProfile Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testViewOtherProfileLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, profile);

	    final ViewGroup.LayoutParams layoutParams = profile.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify LikeButton Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testLikeButtonLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, like);

	    final ViewGroup.LayoutParams layoutParams = like.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify BookmarkButton Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testBookmarkButtonLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, bookmark);

	    final ViewGroup.LayoutParams layoutParams = bookmark.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify EditButton Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testEditButtonLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, edit);

	    final ViewGroup.LayoutParams layoutParams = edit.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
	/**
	 * Verify Spinner Layout Parameters
	 * @throws Exception 
	 */
	@MediumTest
	public void testSpinnerLayout() throws Exception {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mSpinner);

	    final ViewGroup.LayoutParams layoutParams = mSpinner.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    
	    tearDown();
	}
	
//	/**
//	 * Verify ListView Layout Parameters
//	 * @throws Exception 
//	 */
//	@MediumTest
//	public void testListViewLayout() throws Exception {
//		IoStreamHandler io = new IoStreamHandler();
//		io.clean();
//		Thread.sleep(1000);
//		
//	    final View decorView = mActivity.getWindow().getDecorView();
//	    ViewAsserts.assertOnScreen(decorView, mListView);
//	    
//	    final ViewGroup.LayoutParams layoutParams = mListView.getLayoutParams();
//	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
//	    
//	    tearDown();
//	}
	
}
