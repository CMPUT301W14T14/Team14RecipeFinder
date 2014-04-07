/**
 * 
 */
package ca.ualberta.cs.app.testPart4.model;

import model.Comment;
import model.CommentList;
import activity.AllTopicPageActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for CommentList model.
 * 
 * @author Yilu Su
 * 
 */
public class CommentListModelTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor
	 */
	public CommentListModelTest() {
		super(AllTopicPageActivity.class);
	}
	
	/**
     * Test cases for CommentList model. <br>
     * Create a commentList and some comments. 
     * First, add comments to the commentList and check the content. 
     * Then, clear the commentList and check the content again. <br>
     * Methods tested: add, clear, and getCurrentList.
	 * @throws Exception 
     */
    public void testCommentListModel() throws Exception {
    	CommentList commentList = new CommentList();
        Comment comment1 = new Comment("title1", "text1", null, null, "userName1");
        Comment comment2 = new Comment("title2", "text2", null, null, "userName2");
        Comment comment3 = new Comment("title3", "text3", null, null, "userName3");
        
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        
        assertEquals("equal", comment1, commentList.getCurrentList().get(0));
        assertEquals("equal", comment2, commentList.getCurrentList().get(1));
        assertEquals("equal", comment3, commentList.getCurrentList().get(2));
        
        commentList.clear();
        assertEquals("cleared", true, commentList.getCurrentList().isEmpty());
        
        tearDown();
    }

}
