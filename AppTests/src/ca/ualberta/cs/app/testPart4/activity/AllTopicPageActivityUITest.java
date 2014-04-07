package ca.ualberta.cs.app.testPart4.activity;

import com.example.projectapp.R;

import model.Comment;
import model.CommentMap;
import network_io.IoStreamHandler;
import user.UserNameHandler;
import activity.AllTopicPageActivity;
import activity.CreateCommentPageActivity;
import adapter.ListViewAdapter;
import android.app.Instrumentation;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AllTopicPageActivityUITest extends
		ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	public AllTopicPageActivityUITest() {
		super(AllTopicPageActivity.class);
	}
	
	@UiThreadTest
	public void testListViewUpdate() throws InterruptedException {
		getActivity();
		Comment comment = new Comment("Title", "Content", null, null, "User");
		IoStreamHandler ioStreamHandler = new IoStreamHandler();
		Thread thread = new Thread();
		CommentMap commentMap = new CommentMap();
		
//		ArrayAdapter<Comment> adapter = get
		ListViewAdapter listViewAdapter=new ListViewAdapter(getInstrumentation().getTargetContext(),R.layout.single_comment_layout,commentMap.getCurrentList());
		
		ListView listView = (ListView) getActivity().findViewById(com.example.projectapp.R.id.topic_list);
		int before = listView.getChildCount();
		
		ioStreamHandler.addOrUpdateComment(comment);
		thread.join();
		ioStreamHandler.loadAndUpdateTopLevelIdSet(comment.getId(), getActivity());
		thread.join();
		ioStreamHandler.loadTopLevelComments(commentMap, getActivity());
		thread.join();
		
		Thread.sleep(1000);
		
		getActivity().refresh();
		
		
//		ListView listView = (ListView) getActivity().findViewById(com.example.projectapp.R.id.topic_list);
		int after = listView.getChildCount();
		
//		Comment newComment = (Comment) listView.;
		assertEquals(before + 1, after);
		
//		ListViewAdapter<Comment> = getActivity().getAd
	}
	
	
	

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
