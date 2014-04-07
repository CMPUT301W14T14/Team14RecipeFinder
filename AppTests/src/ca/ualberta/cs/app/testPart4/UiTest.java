package ca.ualberta.cs.app.testPart4;

import model.Comment;
import model.CommentMap;
import network_io.IoStreamHandler;
import activity.CommentPageActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

public class UiTest extends ActivityInstrumentationTestCase2<CommentPageActivity> {

	public UiTest() {
		super(CommentPageActivity.class);
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
//		Activity commentPageActivity = getActivity();
//		getActivity().refresh();
//		Activity activity = getActivity();
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
		
		assertEquals("Title", title.getText());
		
	}

}
