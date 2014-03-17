package ca.ualberta.cs.app.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import customlized_gson.Gson_Constructor;

import network_io.ElasticSearchResponse;
import network_io.IoStreamHandler;
import model.Comment;
import model.CommentMap;
import activity.CommentPageActivity;
import activity.HomePageActivity;
import activity.PublishActivity;
import android.app.Activity;
import android.graphics.Bitmap;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

/**
 * JUnit test cases for comment publish
 * 
 * @author yilu
 * 
 */
public class CommentIOTest extends
		ActivityInstrumentationTestCase2<PublishActivity> {

	private PublishActivity publishActivity;
	
	public static final String SERVER_URL="http://cmput301.softwareprocess.es:8080/cmput301w14t14/";
	public static final String LOG_TAG="Elastic Search";
	public static final String favSubKey="FAVOURITES";
	
	private static Gson gson=null;

	/**
	 * Constructor
	 */
	public CommentIOTest() {
		super(PublishActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		publishActivity = getActivity();
	}
	
	/**
	 * Test whether a top level comment can be published to the server and retrieved from the server <br>
	 * First, create a top level comment and push is to the server. Then retrieve it from the server and check the correctness
	 */
	public void testPublishTopLevel() {
		Location location = new Location("location");
		location.setLatitude(100);
		location.setLongitude(100);
		Bitmap picture = Bitmap.createBitmap(20,20 ,Bitmap.Config.ARGB_8888);
		Comment topLevel = new Comment("title", "text", location, picture, "userName");
		
		IoStreamHandler io = new IoStreamHandler();
//		io.load_update_TopLevelIdSet(topLevel.getId(), publishActivity);
		
		io.commitUpdateComment(topLevel);
		
//		HomePageActivity homeActivity;
		
		CommentMap commentMap = new CommentMap();
		CommentPageActivity commentPageActivity = new CommentPageActivity();
		io.loadSpecificComment(topLevel.getId(), commentMap, commentPageActivity);
		Comment comment = loadCommentFromServer(topLevel.getId());
		
		assertEquals(topLevel.getId(), comment.getId());
		assertEquals(topLevel.getTitle(), comment.getTitle());
		assertEquals(topLevel.getText(), comment.getText());
		assertEquals(topLevel.getTimePosted(), comment.getTimePosted());
	}
	
	public void testPublishReply() {
		
	}
	
	/**
	 * 
	 * @param commentId
	 * @return comment in the server found by input Id 
	 */
	public Comment loadCommentFromServer(final String commentId) {
		Comment json = null;
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
//		Thread thread=new Thread(){
//			@Override
//			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+commentId+"/");
				HttpResponse response=null;
				String responseJson = "";
				try{
					response=client.execute(request);
					Log.i(LOG_TAG, "CommentLoad: " + response.getStatusLine().toString());
					HttpEntity entity = response.getEntity();
					BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
					String output = reader.readLine();
//					while (output != null) {
						responseJson+= output;
//						output = reader.readLine();
//					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
//				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				json = gson.fromJson(responseJson, Comment.class);
				assertEquals("aha", json.getId());
				
				
//				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
//				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
//				
//				Runnable getComment = new Runnable() {
//					@Override
//					public void run() {
//						if(Data.getSource()!=null){
//							cm.updateComment(Data.getSource());
//						}
//					}
//				};
//				activity.runOnUiThread(getComment);
//			}
//		};
		
//		thread.start();
		return json;
	}

//	public void testIoStreamHandler() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testCommitUpdateComment() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testLoadSpecificCommentStringCommentMapHomePageActivity() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testLoadSpecificCommentStringCommentMapCommentPageActivity() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testUpdateTopLevelIdSet() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testLoadTopLevelComments() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testLoad_update_TopLevelIdSet() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testLoadAndSetSpecificComment() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testReplySpecificComment() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testCheckEditSpecificComment() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testSet_up_edit_page() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testCommit_edit_comment() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testLoadSpecificCommentForCache() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testLoadSpecificCommentForCacheReply() {
//
//		fail("Not yet implemented");
//	}
//
//	public void testClean() {
//
//		fail("Not yet implemented");
//	}

}
