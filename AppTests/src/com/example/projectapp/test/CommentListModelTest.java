/**
 * 
 */
package com.example.projectapp.test;

import model.Comment;
import model.CommentList;
import junit.framework.TestCase;

/**
 * @author Yilu
 * 
 */
public class CommentListModelTest extends TestCase
{
    /**
     * Test add method
     */
    public void testAdd()
    {

        CommentList commentList = new CommentList();
        Comment comment = new Comment("title", "text", null, "userName");
        commentList.add(comment);
        assertEquals("equal", comment, commentList.getCurrentList().get(0));
    }

    /**
     * Test clear method
     */
    public void testClear()
    {

        CommentList commentList = new CommentList();
        Comment comment = new Comment("title", "text", null, "userName");
        commentList.add(comment);
        assertEquals("equal", comment, commentList.getCurrentList().get(0));
        commentList.clear();
        assertEquals("cleared", true, commentList.getCurrentList().isEmpty());
    }

    /**
     * Test getCurrentList method
     */
    public void testGetCurrentList()
    {

        CommentList commentList = new CommentList();
        Comment comment1 = new Comment("title1", "text1", null, "userName1");
        commentList.add(comment1);
        Comment comment2 = new Comment("title2", "text2", null, "userName2");
        commentList.add(comment2);
        Comment comment3 = new Comment("title3", "text3", null, "userName3");
        commentList.add(comment3);
        assertEquals("equal", comment1, commentList.getCurrentList().get(0));
        assertEquals("equal", comment2, commentList.getCurrentList().get(1));
        assertEquals("equal", comment3, commentList.getCurrentList().get(2));
    }

}
