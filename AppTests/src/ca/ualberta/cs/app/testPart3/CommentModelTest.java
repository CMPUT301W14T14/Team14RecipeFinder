///**
// * 
// */
//package ca.ualberta.cs.app.testPart3;
//
//
//import java.util.Date;
//import activity.PublishActivity;
//import android.graphics.Bitmap;
//import android.location.Location;
//import android.test.ActivityInstrumentationTestCase2;
//import model.Comment;
//
///**
// * JUnit test cases for Comment model.
// * 
// * @author Yilu Su
// *
// */
//public class CommentModelTest extends ActivityInstrumentationTestCase2<PublishActivity> {
//
//	/**
//	 * Constructor 
//	 */
//	public CommentModelTest() {
//		super(PublishActivity.class);
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * Test whether the Id of a comment can be retrieved.
//	 * Create a comment, and check if the Id retrieved by getId method is correct.
//	 */
//	public void testGetId() {
//		Comment comment = new Comment("title","text", null,"userName");
//		Long timestamp = (new Date()).getTime();
//		// This may fail sometime, but the expected and actual are pretty close.
//		// If failed, see failure trace for detail.
//		// I suspect it is due to the time difference between implementing the comment
//		// creation and the assertEquals
//		assertEquals(comment.getId(), "userName"+timestamp);
//	}
//	
//	/**
//	 * Test whether the title of a comment can be retrieved and edited. <br>
//	 * First, create a comment and check if the title retrieved by getTitle method is correct. 
//	 * Then, use the setTitle method to change the title and check if the new title is correct. 
//	 */
//	public void testGetAndSetTitle(){
//		Comment comment = new Comment("title","text", null,"userName");
//		assertEquals(comment.getTitle(), "title");
//		
//		comment.setTitle("new title");
//		assertEquals(comment.getTitle(), "new title");
//	}
//	
//	/**
//	 * Test whether the text of a comment can be retrieved and edited. <br>
//	 * First, create a comment and check if the text retrieved by getText method is correct. 
//	 * Then, use the setText method to change the text and check if the new text is correct. 
//	 */
//	public void testGetAndSetText(){
//		Comment comment = new Comment("title","text", null,"userName");
//		assertEquals(comment.getText(), "text");
//		
//		comment.setText("new text");
//		assertEquals(comment.getText(), "new text");
//	}
//	
//	/**
//	 * Test whether the text of a comment can be retrieved and changed. <br>
//	 * First, create a comment and check if the location retrieved by getLocation 
//	 * method is correct by comparing both latitude and longitude. 
//	 * Then, use the setLocation method to change the location of the comment to a 
//	 * different place and check if the new text is correct by comparing both 
//	 * latitude and longitude. 
//	 */
//	public void testGetAndSetLocation(){
//		Location location1 = new Location("mock");
//		location1.setLatitude(10);
//		location1.setLongitude(20);
//		Comment comment = new Comment("title","text", location1,"userName");
//		assertEquals(comment.getLocation(), location1);
//		assertTrue(comment.getLocation().getLatitude()==10 
//				&& comment.getLocation().getLongitude()==20);
//		
//		Location location2 = new Location("new mock");
//		location2.setLatitude(100);
//		location2.setLongitude(200);
//		comment.setLocation(location2);
//		assertEquals(comment.getLocation(), location2);
//		assertTrue(comment.getLocation().getLatitude()==100 
//				&& comment.getLocation().getLongitude()==200);
//	}
//	
//	/**
//	 * Test whether the picture, timePosted, and userName of a comment can be retrieved. <br>
//	 * First, create a comment with picture, and then check if the retrieved picture, 
//	 * timePosted, and userName by their corresponding getter methods are correct. 
//	 */
//	public void testMoreGetters(){
//		Bitmap pic = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
//		Comment comment = new Comment("title","text", null, pic,"userName");
//		
//		assertEquals(comment.getPicture(), pic);
//		
//		// This may fail sometime, but the expected and actual are pretty close.
//		// If failed, see failure trace for detail.
//		// I suspect it is due to the time difference between implementing the comment
//		// creation and the assertEquals
//		assertEquals((long)comment.getTimePosted(), (new Date()).getTime());
//		
//		assertEquals(comment.getUserName(), "userName");
//	}
//	
//	/**
//	 * Test whether comments can be added as replies of another comment,
//	 * and whether the replies of a comment can be retrieved.  <br>
//	 * First, create three comments and use addReply method to add two of them as replies 
//	 * of the other comment. 
//	 * Then, use the getReplies method to retrieve the replies and check the correctness. 
//	 */
//	public void testGetAndAddReplies(){
//		Comment comment = new Comment("title","text", null,"userName");
//		Comment rp1 = new Comment("title1","text1", null,"userName1");
//		Comment rp2 = new Comment("title2","text2", null,"userName2");
//		comment.addReply(rp1);
//		comment.addReply(rp2);
//		assertEquals(comment.getReplies().get(0), rp1.getId());
//		assertEquals(comment.getReplies().get(1), rp2.getId());
//	}
//	
//	/**
//	 * Test whether a comment can be assigned as parent of another comment 
//	 * using either comment or comment id as the parameter. <br>
//	 * First, create some comments and assign a comment as parent of another 
//	 * comment using both comment and comment id as the parameter, and then 
//	 * check both cases by comparing the Id.
//	 */
//	public void testSetParent(){
//		Comment comment = new Comment("title","text", null,"userName");
//		Comment rp1 = new Comment("title1","text1", null,"userName1");
//		rp1.setParent(comment);
//		assertEquals(rp1.getParentId(), comment.getId());
//		
//		Comment rp2 = new Comment("title2","text2", null,"userName2");
//		rp2.setParent(comment.getId());
//		assertEquals(rp2.getParentId(), comment.getId());
//	}
//	
//	
//	/**
//	 * Test whether the parentId of a comment can be retrieved.
//	 * First, assign a comment as parent of another comment, 
//	 * and then check if the Id retrieved by getParentId method is correct 
//	 * by comparing the Id of the parent comment and the parentId returned 
//	 * from the getParentId method.
//	 */
//	public void testGetParentId(){
//		Comment comment = new Comment("title","text", null,"userName");
//		Comment rp1 = new Comment("title1","text1", null,"userName1");
//		rp1.setParent(comment);
//		assertEquals("equal", rp1.getParentId(), comment.getId());
//	}
//
//}
//
//
