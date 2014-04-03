package ca.ualberta.cs.app.testPart2;
//package ca.ualberta.cs.app.test;
//
//import java.util.ArrayList;
//
//import model.Comment;
//import model.CommentList;
//
//import android.location.Location;
//import android.widget.ListView;
//
//
//
////import android.test.ActivityInstrumentationTestCase2;
////Super class import required in real tests
//
//
///**
// * 
// * @author Yilu
// *
// */
//public class UseCaseTestSkeleton {
//	
//	   //Constructor Required
//	   
//	   public void TestUseCase1(){
//		   CommentList list1=new CommentList();
//		   CommentList list2=new CommentList(); 
//	       //create some comments
//		   //add comments to list1 in order by proximity
//		   //add comments to list2 differently
//		   Location currentLocation=null; //should not be null in real test
//		   ArrayList<Comment> sortedList2=list2.getSortedArrayListByProximityForTesting(currentLocation);
//		   if (sortedList2.equals(list1.getArrayListForTesting())==false){
//			   //raiseError
//		   }
//	   }
//	   
//	   public void TestUseCase2(){
//		   CommentList list1=new CommentList();
//		   CommentList list2=new CommentList(); 
//	       //create some comments
//		   //add comments to list1 in order by proximity
//		   //add comments to list2 differently
//		   Location otherLocation=null; //should not be null in real test
//		   ArrayList<Comment> sortedList2=list2.getSortedArrayListByProximityForTesting(otherLocation);
//		   if (sortedList2.equals(list1.getArrayListForTesting())==false){
//			   //raiseError
//		   }
//	   }
//	   
//	   public void TestUseCase3(){
//	   		CommentList list=new CommentList();
//		   //set the Application's top comments
//		   //run the Activity to add a new comment
//		   //check if the TopLevelActivity's ListView contains the new comment just posted
//	   		list.getSpecificComment().setText("Top level");
//	   		assertTrue(list.getSpecificComment().getText().equals("Top level"));
//	   }
//	   
//	   public void TestUseCase4(){
//		   CommentList list=new CommentList();
//		   //add Comment In list
//		   //list.get(0).setText("Top level");
//		   assertFalse(list.getSpecificComment().getText().equals(null));
//	   }
//	   
//	   public void TestUseCase5(){
//		   CommentList list=new CommentList();
//		   //add Comment In list
//		   Comment target=list.getSpecificComment();
//		   CommentList replies=target.getChildReply();
//		   //Click the targetComment and check in the result ReplyViewActivity, if the content of ListView is the same as the content of replies
//		   assertFalse(replies.getSpecificComment().getText().equals(null));
//	   }
//	   
//	   public void TestUsecase6(){
//		   CommentList list=new CommentList();
//		   Comment target=list.getSpecificComment();
//		   target.addReply(new Comment("bad",(long) 0));
//		   //check if the comment's childReply contains the new reply;
//		   assertFalse(target.getChildReply.getSpecificComment().getText().equals(null));
//	   }
//	   
//	   public void TestUseCase7(){
//	   		//construct a comment with a picture attached
//		    //Add it in the CommentList and set the ListViewAdapter form the method
//		    //check if the picture is shown in the view
//	   		CommentList list=new CommentList();
//	   		Comment target=list.getSpecificComment();
//	   		target.putPicture(Bitmap picture);
//	   		assertFalse(target.getPicture().equals(null));
//	   }
//
//	   public void TestUseCase8 () {
//	   		CommentList list1=new CommentList();
//		   	CommentList list2=new CommentList();
//	       //create some comments with picutures
//		   //add comments to list1 in order by picture
//		   //add comments to list2 randomly
//		   	SortByPictureController sortByPictureController = new SortByPictureController();
//		   	sortByPictureController.sortCommentsByPicture(list2);
//		   	assertTrue(list2.equals(list1));
//	   }
//
//	   public void TestUsecase9 () {
//	   		CommentList list1=new CommentList();
//		   	CommentList list2=new CommentList();
//	       //create some comments at different time
//		   //add comments to list1 in order by date
//		   //add comments to list2 randomly
//		   	SortByDateController sortByDateController = new SortByDateController();
//		   	sortByDateController.sortCommentsByDate(list2);
//		   	assertTrue(list2.equals(list1));
//
//		   	CommentList list1=new CommentList();
//		   	CommentList list2=new CommentList();
//	       //create some comments with different score
//		   //add comments to list1 in order by score
//		   //add comments to list2 randomly
//		   	SortByScoreController sortByScoreController = new SortByScoreController();
//		   	sortByScoreController.sortCommentsByScore(list2);
//		   	assertTrue(list2.equals(list1));
//	   }
//
//	   public void TestUsecase10 () {
//	   		CommentList list1=new CommentList();
//	       //create some comments
//		   //add comments to list1
//	   		CacheController cacheController = new CacheController();
//	   		cacheController.cacheList(list1);
//	   		//Shot down internet
//	   		list1 = cacheController.loadList();
//	   		assertFalse(list1.getSpecificComment().getText().equals(null));
//	   }
//
//	   public void TestUsecase11 () {
//	   		CommentList list1=new CommentList();
//	   		//create some favorite comments
//	   		Comment favoriteComment = new Comment("favorite",(long) 0);
//		   	//add favorite comments to list1
//		   	list1.getSpecificComment().addReply(favoriteComment);
//		   	assertTrue(list1.getSpecificComment().getText.equals("favorite"));
//	   }
//
//	   public void TestUsecase12 () {
//	   		CommentList list1=new CommentList();
//	       //create some favorite comments
//		   //add favorite comments to list1
//	   		CacheController cacheController = new CacheController();
//	   		cacheController.cacheFavorite(list1);
//	   		//Shot down internet
//	   		list1 = cacheController.loadFavorite();
//	   		assertFalse(list1.getSpecificComment().getText().equals(null));
//	   }
//
//
//	   public void TestUsecase13 () {
//	   		CommentList list1=new CommentList();
//	   		//create some comments
//		   	//add comments to list1
//		   	list1.getSpecificComment().setText("edit");
//		   	assertTrue(list1.getSpecificComment().getText.equals("edit"));
//	   }
//
//	   public void TestUsecase14 () {
//	   		CommentList list1=new CommentList();
//	   		//create some comments
//		   	//add comments to list1
//	   		PushController pushController = new PushController();
//	   		pushController.pushComments(list1);
//	   		//may need to test on a different phone
//	   }
//
//	   public void TestUsecase15 () {
//	   		CommentList list1=new CommentList();
//	   		CommentList list2=new CommentList();
//	   		//create some comments on another phone
//	   		NewestController newestController = new NewestController();
//	   		list2 = newestController.pullComments();
//	   		//loop to compare the latest and greast
//	   		for (int i = 0; i < list1.getSize(); i++) {
//	   			//latest and greast?
//	   		}
//	   }
//
//	   public void TestUsecase16 () {
//	   		CommentList list1=new CommentList();
//	   		CommentList list2=new CommentList();
//	   		//create some comments and add comments to list1
//	   		//create some comments on another phone
//	   		NewestController newestController = new NewestController();
//	   		newestController.freshComments(list1);
//	   		//loop to check if fresh
//	   		for (int i = 0; i < list1.getSize(); i++) {
//	   			//fresh?
//	   		}
//	   }
//
//	   public void TestUsecase17 () {
//	   		//create a new comment
//	   		Comment comment=new Comment("bad",(long) 0);
//	   		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
//			Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//			double longitude = location.getLongitude();
//			double latitude = location.getLatitude();
//			Location location2 = comment.getLocation();
//			double longitude2 = location2.getLongitude();
//			double latitude2 = location2.getLatitude();
//			assertTrue(longitude==longitude2);
//			assertTrue(latitude==latitude2);
//	   }
//
//	   public void TestUsecase18 () {
//	   		Comment comment=new Comment("bad",(long) 0);
//	   		//get a new location called newLocation
//	   		comment.setLocation(newLocation);
//			double longitude = comment.getLocation().getLongitude();
//			double latitude = comment.getLocation().getLatitude();
//			double longitude2 = newLocation.getLongitude();
//			double latitude2 = newLocation.getLatitude();
//	   		assertTrue(longitude==longitude2);
//			assertTrue(latitude==latitude2);
//	   }
//
//	   public void TestUsecase19 () {
//	   		CommentList list1=new CommentList();
//	   		NewestController newestController = new NewestController();
//	   		list1 = newestController.pullComments();
//	   		CacheController cacheController = new CacheController();
//	   		cacheController.cacheFavorite(list1);
//	   		//Shot down internet
//	   		list1 = cacheController.loadList();
//	   		assertFalse(list1.getSpecificComment().getText().equals(null));
//	   }
//
//	   public void TestUsecase20 () {
//	   		User user = new User();
//	   		user.setUserName("new");
//	   		assertTrue(user.getUserName.equals("new"));
//	   }
//
//	   public void TestUsecase21 () {
//	   		Comment comment = new Comment();
//	   		assertFalse(comment.getUserName().equals(null));
//	   }
//}
