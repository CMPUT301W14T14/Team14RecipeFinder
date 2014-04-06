package ca.ualberta.cs.app.oldTest;
///**
// * 
// */
//package ca.ualberta.cs.app.testPart3;
//
//import activity.PublishActivity;
//import android.test.ActivityInstrumentationTestCase2;
//import model.Comment;
//import model.CommentList;
//
///**
// * JUnit test cases for CommentList model.
// * 
// * @author Yilu Su
// * 
// */
//public class CommentListModelTest extends ActivityInstrumentationTestCase2<PublishActivity> {
//	
//	/**
//	 * Constructor
//	 */
//    public CommentListModelTest() {
//		super(PublishActivity.class);
//		// TODO Auto-generated constructor stub
//	}
//    
//    /**
//     * Test cases for CommentList model. <br>
//     * Create a commentList and some comments. 
//     * First, add comments to the commentList and check the content. 
//     * Then, clear the commentList and check the content again.
//     */
//    public void testCommentListModel() {
//    	CommentList commentList = new CommentList();
//        Comment comment1 = new Comment("title1", "text1", null, "userName1");
//        Comment comment2 = new Comment("title2", "text2", null, "userName2");
//        Comment comment3 = new Comment("title3", "text3", null, "userName3");
//        
//        commentList.add(comment1);
//        commentList.add(comment2);
//        commentList.add(comment3);
//        
//        assertEquals("equal", comment1, commentList.getCurrentList().get(0));
//        assertEquals("equal", comment2, commentList.getCurrentList().get(1));
//        assertEquals("equal", comment3, commentList.getCurrentList().get(2));
//        
//        commentList.clear();
//        assertEquals("cleared", true, commentList.getCurrentList().isEmpty());
//    }
//
//}
