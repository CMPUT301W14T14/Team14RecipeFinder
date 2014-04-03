///**
// * 
// */
//package ca.ualberta.cs.app.testPart3;
//
//import model.Comment;
//import model.CommentMap;
//import activity.CommentPageActivity;
//import android.test.ActivityInstrumentationTestCase2;
//
///**
// * JUnit test cases for CommentMap model.
// * 
// * @author Yilu Su
// * 
// */
//public class CommentMapModelTest extends ActivityInstrumentationTestCase2<CommentPageActivity> {
//
//	/**
//	 * Constructor
//	 */
//	public CommentMapModelTest() {
//		super(CommentPageActivity.class);
//	}
//	
//    /**
//     * Test cases for CommentMap model. <br>
//     * Create a commentMap and some comments. 
//     * First, use updateComment method to update the comments to the commentMap, 
//     * and then verify the content using getComment and getCurrentList method. 
//     * Finally, clear the commentMap and check the content again.
//     */
//	public void testCommentMapModel() {
//		CommentMap commentMap = new CommentMap();
//		Comment comment1 = new Comment("title1", "text1", null, "userName1");
//		Comment comment2 = new Comment("title2", "text2", null, "userName2");
//		Comment comment3 = new Comment("title3", "text3", null, "userName3");
//		
//		commentMap.updateComment(comment1);
//		commentMap.updateComment(comment2);
//		commentMap.updateComment(comment3);
//		
//		assertEquals(comment1, commentMap.getComment(comment1.getId()));
//		assertEquals(comment2, commentMap.getComment(comment2.getId()));
//		assertEquals(comment3, commentMap.getComment(comment3.getId()));
//		
//		assertEquals(comment1, commentMap.getCurrentList().get(0));
//		assertEquals(comment2, commentMap.getCurrentList().get(1));
//		assertEquals(comment3, commentMap.getCurrentList().get(2));
//		assertEquals(3, commentMap.getCurrentList().size());
//		
//		commentMap.clear();
//		assertTrue(commentMap.getCurrentList().isEmpty());
//	}
//
////	public void testUpdateComment() {
////		CommentMap commentMap = new CommentMap();
////		Comment comment = new Comment("title", "text", null, "userName");
////		commentMap.updateComment(comment);
////		assertEquals(comment, commentMap.getComment(comment.getId()));
////	}
////
////	/**
////	 * Test 
////	 */
////	public void testGetComment() {
////		CommentMap commentMap = new CommentMap();
////		Comment comment = new Comment("title", "text", null, "userName");
////		commentMap.updateComment(comment);
////		assertEquals(comment, commentMap.getComment(comment.getId()));
////	}
////
////	public void testGetCurrentList() {
////		CommentMap commentMap = new CommentMap();
////		Comment comment1 = new Comment("title1", "text1", null, "userName1");
////		Comment comment2 = new Comment("title2", "text2", null, "userName2");
////		Comment comment3 = new Comment("title3", "text3", null, "userName3");
////		commentMap.updateComment(comment1);
////		commentMap.updateComment(comment2);
////		commentMap.updateComment(comment3);
////		assertEquals(comment1, commentMap.getCurrentList().get(0));
////		assertEquals(comment2, commentMap.getCurrentList().get(1));
////		assertEquals(comment3, commentMap.getCurrentList().get(2));
////		assertEquals(3, commentMap.getCurrentList().size());
////	}
////
////	public void testSetArrayAdapter() {
////		CommentMap commentMap = new CommentMap();
////		Comment comment1 = new Comment("title1", "text1", null, "userName1");
////		Comment comment2 = new Comment("title2", "text2", null, "userName2");
////		Comment comment3 = new Comment("title3", "text3", null, "userName3");
////		commentMap.updateComment(comment1);
////		commentMap.updateComment(comment2);
////		commentMap.updateComment(comment3);
////		ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(new HomePageActivity(), 
////				R.layout.single_comment_layout, commentMap.getCurrentList());
////		commentMap.setArrayAdapter(adapter);
////		
////		fail("Not yet implemented");
////	}
////
////	public void testClear() {
////		CommentMap commentMap = new CommentMap();
////		Comment comment1 = new Comment("title1", "text1", null, "userName1");
////		Comment comment2 = new Comment("title2", "text2", null, "userName2");
////		Comment comment3 = new Comment("title3", "text3", null, "userName3");
////		commentMap.updateComment(comment1);
////		commentMap.updateComment(comment2);
////		commentMap.updateComment(comment3);
////		assertEquals(comment1, commentMap.getCurrentList().get(0));
////		assertEquals(comment2, commentMap.getCurrentList().get(1));
////		assertEquals(comment3, commentMap.getCurrentList().get(2));
////		assertEquals(3, commentMap.getCurrentList().size());
////		
////		commentMap.clear();
////		assertTrue(commentMap.getCurrentList().isEmpty());
////	}
//
//}
