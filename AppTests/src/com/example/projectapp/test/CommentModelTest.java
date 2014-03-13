/**
 * 
 */
package com.example.projectapp.test;


import java.util.Date;
import activity.PublishActivity;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;
import model.Comment;

/**
 * @author Yilu
 *
 */
public class CommentModelTest extends ActivityInstrumentationTestCase2<PublishActivity> {

	public CommentModelTest() {
		super(PublishActivity.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Test getId method
	 */
	public void testGetId() {
		Comment comment = new Comment("title","text", null,"userName");
		Long timestamp = (new Date()).getTime();
//		assertEquals(comment.getId(), "userName"+(new Date()).getTime());
		assertEquals(comment.getId(), "userName"+timestamp);
	}
	
	/**
	 * Test getTitle method
	 */
	public void testGetTitle(){
		Comment comment = new Comment("title","text", null,"userName");
		assertEquals(comment.getTitle(), "title");
	}
	
	/**
	 * Test setTitle method
	 */
	public void testSetTitle(){
		Comment comment = new Comment("title","text", null,"userName");
		comment.setTitle("new title");
		assertEquals(comment.getTitle(), "new title");
	}
	
	/** 
	 * Test getText method
	 */
	public void testGetText(){
		Comment comment = new Comment("title","text", null,"userName");
		assertEquals(comment.getText(), "text");
	}
	
	/**
	 * Test setText method
	 */
	public void testSetText(){
		Comment comment = new Comment("title","text", null,"userName");
		comment.setText("new text");
		assertEquals(comment.getText(), "new text");
	}
	
	/**
	 * Test getLocation method
	 */
	public void testGetLocation(){
		Location location = new Location("GPS_PROVIDER");
		Comment comment = new Comment("title","text", location,"userName");
		Location lc = comment.getLocation();
		double lat = lc.getLatitude();
		double lng = lc.getLongitude();
		assertTrue(lat==0&&lng==0);
	}
	
	/**
	 * Test setLocation method
	 */
	public void testSetLocation(){
		Comment comment = new Comment("title","text", null,"userName");
		Location location = new Location("GPS_PROVIDER");
		comment.setLocation(location);
		assertTrue(comment.getLocation()!=null);
	}
	
	/**
	 * Test getPicture method
	 */
	public void testGetPicture(){
		Comment comment = new Comment("title","text", null, null,"userName");
		assertEquals(comment.getPicture(), null);
	}
	
	/**
	 * Test getTimePosted method
	 */
	public void testGetTimePosted(){
		Comment comment = new Comment("title","text", null,"userName");
		assertTrue(comment.getTimePosted().equals((new Date()).getTime()));
	}
	
	/**
	 * Test getUserName method
	 */
	public void testGetUserName(){
		Comment comment = new Comment("title","text", null,"userName");
		assertEquals(comment.getUserName(), "userName");
	}
	
	/**
	 * Test getReplies method
	 */
	public void testGetReplies(){
		Comment comment = new Comment("title","text", null,"userName");
		Comment rp1 = new Comment("title1","text1", null,"userName1");
		Comment rp2 = new Comment("title2","text2", null,"userName2");
		comment.addReply(rp1);
		comment.addReply(rp2);
		assertTrue( (comment.getReplies().get(0).equals(rp1.getId())) 
		        && (comment.getReplies().get(1).equals(rp2.getId())) );
	}

	/**
	 * Test addReply methods
	 */
	public void testAddReply(){
		Comment comment = new Comment("title","text", null,"userName");
		Comment rp1 = new Comment("title1","text1", null,"userName1");
		comment.addReply(rp1);
		assertTrue(comment.getReplies().get(0).equals(rp1.getId()));
		Comment rp2 = new Comment("title2","text2", null,"userName2");
		comment.addReply(rp2.getId());
		assertTrue(comment.getReplies().get(1).equals(rp2.getId()));
	}
	
	/**
	 * Test setParent methods
	 */
	public void testSetParent(){
		Comment comment = new Comment("title","text", null,"userName");
		Comment rp1 = new Comment("title1","text1", null,"userName1");
		rp1.setParent(comment);
		assertTrue(rp1.getParentId().equals(comment.getId()));
		
		Comment rp2 = new Comment("title2","text2", null,"userName2");
		rp2.setParent(comment.getId());
		assertTrue(rp2.getParentId().equals(comment.getId()));
	}
	
	
//	/**
//	 * Test getParentId method
//	 */
//	public void testGetParentId(){
//		Comment comment = new Comment("title","text", null,"userName");
//		Comment rp1 = new Comment("title1","text1", null,"userName1");
//		comment.addReply(rp1);
//		assertTrue(rp1.getParentId().equals(comment.getId()));
//	}

}


