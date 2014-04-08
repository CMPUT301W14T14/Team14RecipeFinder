/**
 * 
 */
package ca.ualberta.cs.app.testPart4.activity;

import activity.AllTopicPageActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * JUnit test cases for AllTopicPageActivity.
 * 
 * @author Yilu Su
 *
 */
public class AllTopicPageActivityTest extends
		ActivityInstrumentationTestCase2<AllTopicPageActivity> {
	

	AllTopicPageActivity mActivity;
	Spinner mSpinner;
	ListView mListView;
	
	/**
	 * Constructor 
	 */
	public AllTopicPageActivityTest() {
		super(AllTopicPageActivity.class);
	}
	
	/**
     * Sets up the test environment before each test.
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
	@Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        mActivity = getActivity();
        mSpinner = (Spinner) mActivity.findViewById(com.example.projectapp.R.id.all_topic_spinner);
        mListView = (ListView) mActivity.findViewById(com.example.projectapp.R.id.topic_list);
    }
	
	/**
	 * Verify Spinner Layout Parameters
	 */
	@MediumTest
	public void testSpinnerLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mSpinner);

	    final ViewGroup.LayoutParams layoutParams = mSpinner.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify ListView Layout Parameters
	 */
	@MediumTest
	public void testListViewLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();
	    ViewAsserts.assertOnScreen(decorView, mListView);
	    
	    final ViewGroup.LayoutParams layoutParams = mListView.getLayoutParams();
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	
	
	
	
	
//	Activity activity;
//	IoStreamHandler ioStreamHandler;
//	Thread thread;
//	CommentMap commentMap;
//	
//	Spinner spinner;
//	int TEST_STATE_DESTROY_POSITION = 10;
//	
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		
//		setActivityInitialTouchMode(true);
//		
//		activity = getActivity();
//		
//		Comment comment1 = new Comment("Title1", "Content1", null, null, "User1");
//		Comment comment2 = new Comment("Title2", "Content2", null, null, "User2");
//		ioStreamHandler = new IoStreamHandler();
//		thread = new Thread();
////		commentMap = new CommentMap();
//		
//		thread = ioStreamHandler.addOrUpdateComment(comment1);
//		thread.join();
//		thread = ioStreamHandler.addOrUpdateComment(comment2);
//		thread.join();
//		thread = ioStreamHandler.loadAndUpdateTopLevelIdSet(comment1.getId(), getActivity());
//		thread.join();
//		thread = ioStreamHandler.loadAndUpdateTopLevelIdSet(comment2.getId(), getActivity());
//		thread.join();
//		Thread.sleep(1000);
//		
////		Intent intent = new Intent();
////		intent.putExtra("CommentID", comment.getId());
////		setActivityIntent(intent);
////		activity = getActivity();
//	}
//	
//	
//	
//	@UiThreadTest
//	public void testListViewUpdate() throws InterruptedException {
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
////		getActivity();
////		Comment comment = new Comment("Title", "Content", null, null, "User");
////		ArrayAdapter<Comment> adapter = get
////		ListViewAdapter listViewAdapter=new ListViewAdapter(getInstrumentation().getTargetContext(),R.layout.single_comment_layout,commentMap.getCurrentList());
////		
////		ListView listView = (ListView) getActivity().findViewById(com.example.projectapp.R.id.topic_list);
////		int before = listView.getChildCount();
////		
////		ioStreamHandler.addOrUpdateComment(comment);
////		thread.join();
////		ioStreamHandler.loadAndUpdateTopLevelIdSet(comment.getId(), getActivity());
////		thread.join();
////		ioStreamHandler.loadTopLevelComments(commentMap, getActivity());
////		thread.join();
////		
////		Thread.sleep(1000);
////		
////		getActivity().refresh();
//		
//		
////		ListView listView = (ListView) getActivity().findViewById(com.example.projectapp.R.id.topic_list);
////		int after = listView.getChildCount();
//		
////		Comment newComment = (Comment) listView.;
////		assertEquals(before + 1, after);
//		
////		ListViewAdapter<Comment> = getActivity().getAd
//	}
	
	
	

//	@UiThreadTest
//	public void testAllTopicPageActivityUpdate() {
//		Intent intent = new Intent();
//		setActivityIntent(intent);
//		AllTopicPageActivity allTopicPageActivity = getActivity();
//		allTopicPageActivity.refresh();
//		ListView topicList = (ListView) allTopicPageActivity.findViewById(com.example.projectapp.R.id.topic_list);
//		assertNotNull(topicList);
////		topicList.performItemClick(topicList.getAdapter().getView(0, null, null), 0, 0);
//
//		allTopicPageActivity.finish();
//	}

	// write the integration test for editing a comment!
//	@UiThreadTest
//	public void testEditTopic() throws Throwable {
//		Intent intent = new Intent();
//		setActivityIntent(intent);
//		AllTopicPageActivity allTopicPageActivity = getActivity();
//		assertNotNull(allTopicPageActivity);
//
//		Instrumentation.ActivityMonitor submissionMonitor = getInstrumentation().addMonitor(CreateCommentPageActivity.class.getName(), null, false);
//		Menu menu = allTopicPageActivity.getMenu();
//		menu.performIdentifierAction(com.example.projectapp.R.id.action_create, 0);
//
//		final CreateCommentPageActivity create = (CreateCommentPageActivity) getInstrumentation().waitForMonitorWithTimeout(submissionMonitor, 5000);
//		assertNotNull(create);
//
//		/* make the comment */
//		// Create the Topic
//		UserNameHandler userNameHandler=new UserNameHandler();
//		
//		EditText title = (EditText) create.findViewById(com.example.projectapp.R.id.create_title);
//		EditText content = (EditText) create.findViewById(com.example.projectapp.R.id.create_content);
//		ImageButton commit = (ImageButton) create.findViewById(com.example.projectapp.R.id.create_commit);
//
//		assertNotNull(title);
//		assertNotNull(content);
//
//		title.setText("title");
//		userNameHandler.setUserName(getActivity(), "User");
//		content.setText("text");
//
//		commit.performClick();
//
//		// give the topic a second to get pushed to the server
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		/* make sure we have entered the CreateSubmissionController Activity */
//
////		ArrayList<CommentTreeElement> topics = SortFunctions.sortByNewest(CommentTree.getInstance().getChildren(homeView));
////		CommentTreeElement topic = topics.get(0);
////
////		assertEquals("Titles not the same", topic.getTitle(), title.getText().toString());
////		assertEquals("Usernames not the same", topic.getUsername(), username.getText().toString());
////		assertEquals("Texts not the same", topic.getCommentText(), commentText.getText().toString());
//
//		/* Now click the comment and edit it */
//		// Instrumentation.ActivityMonitor homeViewMonitor =
//		// getInstrumentation().addMonitor(HomeViewController.class.getName(),
//		// null , false);
//		// give the topic a second to get pushed to the server
//
//		/* stop the runnable here */
//
//		/* I don't think I am correctly in the activity I think I am */
//		allTopicPageActivity = getActivity();
//		allTopicPageActivity.refresh();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		ListView topicList = (ListView) allTopicPageActivity.findViewById(com.example.projectapp.R.id.topic_list);
//		assertNotNull(topicList);
//
//		/* click the newly created topic */
//		topicList.performItemClick(topicList.getAdapter().getView(0, null, null), 0, 0);
//
//		/* you are now in the new Activity, so change the parameters */
//		/*
//		 * title.setText("title_new"); username.setText("User2");
//		 * commentText.setText("text_new");
//		 * 
//		 * submitButton.performClick(); topics =
//		 * SortFunctions.sortByNewest(ct.getChildren(homeView)); topics.get(0);
//		 * 
//		 * assertEquals("Titles not the same", topic.getTitle(),
//		 * title.getText().toString() ); assertEquals("Usernames not the same",
//		 * topic.getUsername(), username.getText().toString());
//		 * assertEquals("Texts not the same", topic.getCommentText(),
//		 * commentText.getText().toString());
//		 */
//
//		allTopicPageActivity.finish();
//	}
}
