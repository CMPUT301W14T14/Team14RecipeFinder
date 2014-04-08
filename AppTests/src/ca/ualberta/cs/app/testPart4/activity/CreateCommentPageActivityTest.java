package ca.ualberta.cs.app.testPart4.activity;

import activity.CreateCommentPageActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CreateCommentPageActivityTest extends
		ActivityInstrumentationTestCase2<CreateCommentPageActivity> {

	CreateCommentPageActivity mActivity;
	EditText title;
	EditText content;
	ImageView picture;
	ImageButton commit;
	ImageButton cancel;

	/**
	 * Constructor 
	 */
	public CreateCommentPageActivityTest() {
		super(CreateCommentPageActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();

        setActivityInitialTouchMode(true);

        mActivity = getActivity();
        
		title = (EditText)mActivity.findViewById(com.example.projectapp.R.id.create_title);
		content = (EditText)mActivity.findViewById(com.example.projectapp.R.id.create_content);
		picture = (ImageView)mActivity.findViewById(com.example.projectapp.R.id.create_image_review);
		commit = (ImageButton) mActivity.findViewById(com.example.projectapp.R.id.create_commit);
		cancel = (ImageButton) mActivity.findViewById(com.example.projectapp.R.id.create_cancel);
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

}
