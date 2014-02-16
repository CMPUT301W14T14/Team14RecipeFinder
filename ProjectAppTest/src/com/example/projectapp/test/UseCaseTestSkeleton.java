package com.example.projectapp.test;

import java.util.ArrayList;

import android.location.Location;
import android.widget.ListView;

import com.example.projectapp.Comment;
import com.example.projectapp.CommentList;

//import android.test.ActivityInstrumentationTestCase2;
//Super class import required in real tests



public class UseCaseTestSkeleton {
	
	   //Constructor Required
	   
	   public void TestUseCase1(){
		   CommentList list1=new CommentList();
		   CommentList list2=new CommentList(); 
	       //create some comments
		   //add comments to list1 in order by proximity
		   //add comments to list2 differently
		   Location currentLocation=null; //should not be null in real test
		   ArrayList<Comment> sortedList2=list2.getSortedArrayListByProximityForTesting(currentLocation);
		   if (sortedList2.equals(list1.getArrayListForTesting())==false){
			   //raiseError
		   }
	   }
	   
	   public void TestUseCase2(){
		   CommentList list1=new CommentList();
		   CommentList list2=new CommentList(); 
	       //create some comments
		   //add comments to list1 in order by proximity
		   //add comments to list2 differently
		   Location otherLocation=null; //should not be null in real test
		   ArrayList<Comment> sortedList2=list2.getSortedArrayListByProximityForTesting(otherLocation);
		   if (sortedList2.equals(list1.getArrayListForTesting())==false){
			   //raiseError
		   }
	   }
	   
	   public void TestUseCase3(){
		   //set the Application's top comments
		   //run the Activity to add a new comment
		   //check if the TopLevelActivity's ListView contains the new comment just posted
	   }
	   
	   public void TestUseCase4(){
		   CommentList list=new CommentList();
		   //add Comment In list
		   //ListView v.setListViewAdapter(list.getListViewAdapterSortedByTimePosted());
		   //check if the TopLevelActivity's ListView contains all comment in list
	   }
	   
	   public void TestUseCase5(){
		   CommentList list=new CommentList();
		   //add Comment In list
		   Comment target=list.getSpecificComment();
		   CommentList replies=target.getChildReply();
		   //Click the targetComment and check in the result ReplyViewActivity, if the content of ListView is the same as the content of replies
	   }
	   
	   public void TestUsecase6(){
		   CommentList list=new CommentList();
		   Comment target=list.getSpecificComment();
		   target.addReply(new Comment("bad",(long) 0));
		   //check if the comment's childReply contains the new reply;
	   }
	   
	   public void TestUseCase7(){
		   //construct a comment with a picture attached
		   //Add it in the CommentList and set the ListViewAdapter form the method
		   //check if the picture is shown in the view
	   }
}
