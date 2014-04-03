//package ca.ualberta.cs.app.testPart3;
//
//import network_io.IoStreamHandler;
//import model.Comment;
//import activity.CommentPageActivity;
//import android.graphics.Bitmap;
//import android.location.Location;
//import android.test.ActivityInstrumentationTestCase2;
//
///**
// * JUnit test cases for comment publish
// * 
// * @author yilu
// * 
// */
//public class CommentIOTest extends
//		ActivityInstrumentationTestCase2<CommentPageActivity> {
//
////	private CommentPageActivity commentPageActivity;
//	
//	public static final String SERVER_URL="http://cmput301.softwareprocess.es:8080/cmput301w14t14/";
//	public static final String LOG_TAG="Elastic Search";
//	public static final String favSubKey="FAVOURITES";
//	
////	private static Gson gson=null;
//	
//	public Comment comment;
//
//	/**
//	 * Constructor
//	 */
//	public CommentIOTest() {
//		super(CommentPageActivity.class);
//	}
//
////	@Override
////	protected void setUp() throws Exception {
////		super.setUp();
////		commentPageActivity = getActivity();
////	}
//	
//	/**
//	 * Test whether a top level comment can be published to the server and retrieved from the server <br>
//	 * First, create a top level comment and push it to the server. Then retrieve it from the server and check the correctness
//	 */
//	public void testPublishTopLevel() {
//		Location location = new Location("location");
//		location.setLatitude(100);
//		location.setLongitude(100);
//		Bitmap picture = Bitmap.createBitmap(20,20 ,Bitmap.Config.ARGB_8888);
//		Comment topLevel = new Comment("title", "text", location, picture, "userName");
//		
//		IoStreamHandler io = new IoStreamHandler();
//		io.commitUpdateComment(topLevel);
//		comment = loadCommentFromServer(topLevel.getId());
//
//		fail("Not yet implemented");
////		assertEquals(topLevel.getId(), comment.getId());
////		assertEquals(topLevel.getTitle(), comment.getTitle());
////		assertEquals(topLevel.getText(), comment.getText());
////		assertEquals(topLevel.getTimePosted(), comment.getTimePosted());
//	}
//	
//	/**
//	 * Test whether a comment can be added as reply of another comment and published to the server, and retrieved from the server <br>
//	 * First, add comment as reply of another comment and push them to the server. Then retrieve them from the server and check the correctness
//	 */
//	public void testPublishReply() {
//		Location location = new Location("location");
//		location.setLatitude(100);
//		location.setLongitude(100);
//		Bitmap picture = Bitmap.createBitmap(20,20 ,Bitmap.Config.ARGB_8888);
//		Comment reply = new Comment("title", "text", location, picture, "userName");
//		Comment topLevel = new Comment("title", "text", location, picture, "userName");
//		reply.setParent(topLevel);
//		topLevel.addReply(reply);
//		
//		IoStreamHandler io = new IoStreamHandler();
//		io.commitUpdateComment(reply);
//		io.commitUpdateComment(topLevel);
//		comment = loadCommentFromServer(reply.getId());
//
//		fail("Not yet implemented");
////		assertEquals(reply.getId(), comment.getId());
////		assertEquals(reply.getTitle(), comment.getTitle());
////		assertEquals(reply.getText(), comment.getText());
////		assertEquals(reply.getTimePosted(), comment.getTimePosted());
////		assertEquals(topLevel.getId(), comment.getId());
////		assertEquals(topLevel.getTitle(), comment.getTitle());
////		assertEquals(topLevel.getText(), comment.getText());
////		assertEquals(topLevel.getTimePosted(), comment.getTimePosted());
//	}
//	
//	/**
//	 * Method to retrieve data from server
//	 */
//	public Comment loadCommentFromServer(final String commentId) {
//		return comment;
//	}
//	
////	/**
////	 * 
////	 * @param commentId
////	 * @return comment in the server found by input Id 
////	 */
////	public Comment loadCommentFromServer(final String commentId) {
////		if(gson==null){
////			gson=(new Gson_Constructor()).getGson();
////		}
////		Thread thread=new Thread(){
////			@Override
////			public void run(){
////				HttpClient client=new DefaultHttpClient();
////				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+commentId+"/");
////				HttpResponse response=null;
////				String responseJson = "";
////				try{
////					response=client.execute(request);
////					Log.i(LOG_TAG, "CommentLoad: " + response.getStatusLine().toString());
////					HttpEntity entity = response.getEntity();
////					BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
////					String output = reader.readLine();
////					while (output != null) {
////						responseJson+= output;
////						output = reader.readLine();
////					}
////				} 
////				catch (ClientProtocolException e){
////					e.printStackTrace();
////				} 
////				catch (IOException e){
////					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
////					e.printStackTrace();
////				}		
////				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
////				comment = gson.fromJson(responseJson, Comment.class);
////				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
////				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
////				
////				Runnable getComment = new Runnable() {
////					@Override
////					public void run() {
////						if(Data.getSource()!=null){
////							cm.updateComment(Data.getSource());
////						}
////					}
////				};
////				activity.runOnUiThread(getComment);
////			}
////		};
////		thread.start();
////		return comment;
////	}
//
//	/**
//	 * Test whether a comment can be retrieved from server by its id and put into a CommentMap in the HomePageActivity(top level)
//	 */
//	public void testLoadSpecificCommentStringCommentMapHomePageActivity() {
//
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test whether a comment can be retrieved from server by its id and put into a CommentMap in the CommentPageActivity(sub level)
//	 */
//	public void testLoadSpecificCommentStringCommentMapCommentPageActivity() {
//
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * 	Test whether the TopLevelIdSet in the server can be updated 
//	 */
//	public void testUpdateTopLevelIdSet() {
//
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test whether the TopLevelComments can be loaded into a commentMap in the HomePageActivity(top level)
//	 */
//	public void testLoadTopLevelComments() {
//
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test whether a commentId can be added to the TopLevelIdSet in the server and update it in the activity
//	 */
//	public void testLoad_update_TopLevelIdSet() {
//
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test whether a comment can be load and set to the View
//	 */
//	public void testLoadAndSetSpecificComment() {
//
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test whether the author is checked to allow a comment to be edited
//	 */
//	public void testCheckEditSpecificComment() {
//
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test whether a comment in the server can also be locally cached
//	 */
//	public void testLoadSpecificCommentForCache() {
//
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test whether data in the server can be cleared
//	 */
//	public void testClean() {
//
//		fail("Not yet implemented");
//	}
//
//}
