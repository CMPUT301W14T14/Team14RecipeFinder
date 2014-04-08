package ca.ualberta.cs.app.testPart4.activity;

import com.google.gson.Gson;

import customlized_gson.GsonConstructor;
import model.Comment;
import activity.LocalCommentPageActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * JUnit test cases for LocalCommentPageActivity.
 * 
 * @author Yilu Su
 *
 */
public class LocalCommentPageActivityTest extends
		ActivityInstrumentationTestCase2<LocalCommentPageActivity> {
	
	private Gson gson=(new GsonConstructor()).getGson();
	
	LocalCommentPageActivity mActivity;
	TextView title;
	TextView content;
	TextView commentInfo;
	ImageView picture;

	/**
	 * Constructor 
	 */
	public LocalCommentPageActivityTest() {
		super(LocalCommentPageActivity.class);
	}
	
	/**
     * Sets up the test environment before each test.
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
	@Override
	protected void setUp() throws Exception {
		super.setUp();

        setActivityInitialTouchMode(true);
        Comment comment = new Comment("title", "content", null, null, "user");
        Intent intent = new Intent();
        intent.putExtra("commentJson",gson.toJson(comment));
        setActivityIntent(intent);

        mActivity = getActivity();
		title = (TextView)mActivity.findViewById(com.example.projectapp.R.id.local_comment_title);
		content = (TextView)mActivity.findViewById(com.example.projectapp.R.id.local_comment_content);
		commentInfo = (TextView)mActivity.findViewById(com.example.projectapp.R.id.local_comment_info);
		picture = (ImageView)mActivity.findViewById(com.example.projectapp.R.id.local_topic_image);
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
	    assertEquals("title", title.getText().toString());
	    
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
	    assertEquals("content", content.getText().toString());
	    
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

}
