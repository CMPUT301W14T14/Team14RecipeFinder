package ca.ualberta.cs.app.testPart4.activity;

import cache.CacheController;
import model.Comment;
import model.CommentList;
import network_io.IoStreamHandler;
import activity.CommentPageActivity;
import activity.FavoritePageActivity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.ImageButton;

public class NewActivityTest extends ActivityInstrumentationTestCase2<CommentPageActivity> {

	Comment comment;
	Thread thread;
	IoStreamHandler ioStreamHandler;
	Location location;
	
	public NewActivityTest() {
		super(CommentPageActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	@UiThreadTest
	public void testFavClickListener() throws InterruptedException {
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
		intent.putExtra("CommentId", comment.getId());
		setActivityIntent(intent);
		
		CommentPageActivity activity = getActivity();
		

		
		
		
		
		
		
		ImageButton fav = (ImageButton) getActivity().findViewById(com.example.projectapp.R.id.comment_like);
		fav.performClick();
		Thread.sleep(1000);
		CommentList commentList = new CommentList();
		CacheController cacheController=new CacheController();
		commentList=cacheController.getResource(getActivity(),"fav");
		Thread.sleep(500);
		assertTrue(commentList.getCurrentList().contains(comment));
		
//		assertEquals();
	}

}
