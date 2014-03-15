package network_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Date;

import model.Comment;
import model.CommentMap;
import model.IdSet;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import activity.CommentPageActivity;
import activity.EditPageActivity;
import activity.HomePageActivity;
import activity.PublishActivity;
//import android.location.Location;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cache.CacheController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import customlized_gson.Gson_Constructor;


/**
 * a network controller used to get and update comment from/to the server.
 * Adapted From https://github.com/zjullion/PicPosterComplete/blob/master/src/ca/ualberta/cs/picposter/network/ElasticSearchOperations.java
 */
public class IoStreamHandler {
	public static final String SERVER_URL="http://cmput301.softwareprocess.es:8080/cmput301w14t14/";
	public static final String LOG_TAG="Elastic Search";
	public static final String favSubKey="FAVOURITES";
	
	private static Gson gson=null;
	
	public IoStreamHandler(){}
	
	/**
	 * update a comment with its own id to the web server, if the comment with the same id doesn't exist, then this comment will be added to the server.
	 */
	
	public void commitUpdateComment(final Comment comment){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpPut request = new HttpPut(SERVER_URL+"Comment/"+comment.getId()+"/");
				try{
					request.setEntity(new StringEntity(gson.toJson(comment)));
				}
				catch(UnsupportedEncodingException exception){
					Log.w(LOG_TAG, "Error during Encoding: " + exception.getMessage());
					return;
				}
				
				HttpResponse response=null;
				try{
					response = client.execute(request);
					Log.i(LOG_TAG, "CommentUpdate: " + response.getStatusLine().toString());
				}
				catch(IOException exception){
					Log.w(LOG_TAG, "Error during Update: " + exception.getMessage());
				}
			}
		};
		thread.start();
	}
	
	/**
	 * put A Comment with the specific id into the CommentMap from the web server in the HomePageActivity(top level).
	 */
	
	public void loadSpecificComment(final String commentId,final CommentMap cm,final HomePageActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
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
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				
				Runnable getComment = new Runnable() {
					@Override
					public void run() {
						if(Data.getSource()!=null){
							cm.updateComment(Data.getSource());
						}
					}
				};
				activity.runOnUiThread(getComment);
			}
		};
		thread.start();
	}
	
	/**
	 * put a Comment in to the CommentMap with the specific id from the web server in the CommentPageActivity(sub level).
	 */
	public void loadSpecificComment(final String commentId,final CommentMap cm,final CommentPageActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
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
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				
				Runnable getComment = new Runnable() {
					@Override
					public void run() {
						if(Data.getSource()!=null){
							cm.updateComment(Data.getSource());
						}
					}
				};
				activity.runOnUiThread(getComment);
			}
		};
		thread.start();
	}
	
	/**
	 * update the top level comment's IdSet which stored in the server, if there's nothing in the server, then add it to the server.
	 */
	
	public void updateTopLevelIdSet(final IdSet topLevelIdSet){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpPut request = new HttpPut(SERVER_URL+"IdSet/topLevelId/");
				try {
					request.setEntity(new StringEntity(gson.toJson(topLevelIdSet)));
				} 
				catch (UnsupportedEncodingException e) {
					Log.w(LOG_TAG, "Error during Encoding: " + e.getMessage());
					e.printStackTrace();
				}
				HttpResponse response=null;
				try {
					response = client.execute(request);
					Log.i(LOG_TAG, "SetUpdate: " + response.getStatusLine().toString());
				} 
				catch (ClientProtocolException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					Log.w(LOG_TAG, "Error during Update: " + e.getMessage());
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}
	/**
	 * Load all of the top level comments in to the CommentMap
	 */
	
	public void loadTopLevelComments(final CommentMap topLevelComments,final HomePageActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"IdSet/topLevelId/");
				HttpResponse response=null;
				String responseJson = "";
				try {
					response=client.execute(request);
					Log.i(LOG_TAG, "SetLoad: " + response.getStatusLine().toString());
					HttpEntity entity = response.getEntity();
					BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
					String output = reader.readLine();
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<IdSet>>(){}.getType();
				final ElasticSearchResponse<IdSet> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				IdSet idSet=Data.getSource();
				if(idSet!=null){
					for(String id : idSet.getSet()){
						loadSpecificComment(id,topLevelComments,activity);
					}
				}
			}
		};
		thread.start();
	}
	/**
	 * Add a comment id to the top level IdSet and update the IdSet in the server while publish a new top level comment.
	 * @param id
	 * @param activity
	 */
	
	public void load_update_TopLevelIdSet(final String id,final PublishActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"IdSet/topLevelId/");
				HttpResponse response=null;
				String responseJson = "";
				try {
					response=client.execute(request);
					Log.i(LOG_TAG, "SetLoad: " + response.getStatusLine().toString());
					HttpEntity entity = response.getEntity();
					BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
					String output = reader.readLine();
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<IdSet>>(){}.getType();
				final ElasticSearchResponse<IdSet> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				Runnable getIdSet = new Runnable() {
					@Override
					public void run() {
						IdSet idSet=Data.getSource();
						if(idSet==null){
							idSet=new IdSet();
						}
						idSet.add(id);
						updateTopLevelIdSet(idSet);
					}
				};
				activity.runOnUiThread(getIdSet);
			}
		};
		thread.start();
	}
	
	/**
	 * Load a specific Comment by its own Id ; Set the content of this comment in to a TextView ;Set anthorInfo,time posted and location(if its not null) of this comment
	 * into another TextView;Set picture of this comment(if not null) in to an imageView, and all of this comment's replies in to a list view. In the UI: CommentPageActivity.
	 * @param commentId
	 * @param commentView
	 * @param authorInfo
	 * @param pic
	 * @param cm
	 * @param activity
	 */
	
	public void loadAndSetSpecificComment(final String commentId,final TextView commentView,final TextView authorInfo,final ImageView pic,final CommentMap cm,final CommentPageActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+commentId+"/");
				HttpResponse response=null;
				String responseJson = "";
				try{
					response=client.execute(request);
					Log.i(LOG_TAG, "CommentLoadAndSet: " + response.getStatusLine().toString());
					HttpEntity entity = response.getEntity();
					BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
					String output = reader.readLine();
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				Runnable getAndSetComment = new Runnable() {
					@Override
					public void run() {
						Comment c=Data.getSource();
						if(c!=null){
							commentView.setText(c.getText());
							pic.setImageBitmap(c.getPicture());
							Location loc=c.getLocation();
							if(loc!=null){
								double lat=loc.getLatitude();
								double lng=loc.getLongitude();
								String lngS=String.valueOf(lng);
								String latS=String.valueOf(lat);
								authorInfo.setText("Posted By : "+c.getUserName()+" At : "+((new Date(c.getTimePosted())).toString())+"\nLocation At: Longitude: "+lngS+"  Latitude: "+latS);
							}
							else{
								authorInfo.setText("Posted By : "+c.getUserName()+" At : "+((new Date(c.getTimePosted())).toString()));
							}
							for(String id : c.getReplies()){
								loadSpecificComment(id,cm,activity);
							}
						}
					}
				};
				activity.runOnUiThread(getAndSetComment);
			}
		};
		thread.start();
	}
	
	/**
	 * Load a specific Comment by it's id and add an reply Comment's id to this comment's reply IdSet.
	 * @param commentId
	 * @param replyId
	 */
	public void replySpecificComment(final String commentId,final String replyId){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
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
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				Comment c=Data.getSource();
				c.addReply(replyId);
				commitUpdateComment(c);
			}
		};
		thread.start();
	}
	
	
	/**
	 * check if the given userName is the same of the author of the comment with the given comment id, if it is, direct the user to the EditPage in the UI thread(CommentPageActivity).
	 * Otherwise, make a toast tell the user he/she can't edit that comment.
	 * @param commentId
	 * @param userName
	 * @param activity
	 */
	public void checkEditSpecificComment(final String commentId,final String userName,final CommentPageActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
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
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				
				Runnable editCommand = new Runnable() {
					@Override
					public void run() {
						Comment c=Data.getSource();
						if(c.getUserName().equals(userName)==false){
							Toast.makeText(activity.getApplicationContext(),"Only Author can edit the comment.",Toast.LENGTH_SHORT).show();
						}
						else{
							Intent edit_intent=new Intent(activity,EditPageActivity.class);
							edit_intent.putExtra("comment_id",commentId);
							activity.startActivity(edit_intent);
						}
						
					}
				};
				activity.runOnUiThread(editCommand);
			}
		};
		thread.start();
	}
	/**
	 * Load a specific comment, Set the content of this comment in to a EditText, Set the title of this comment in to a EditText, set the author info ,time posted,and the location
	 * (if not null) into a TextView, set the Picture of this comment(if not null) in to an ImageView in the EditPageActivity.
	 * @param commentId
	 * @param title
	 * @param content
	 * @param pic
	 * @param activity
	 */
	public void set_up_edit_page(final String commentId,final EditText title,final EditText content,final ImageView pic,final EditPageActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
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
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				
				Runnable editSetup = new Runnable(){
                    @Override
					public void run(){
						Comment c=Data.getSource();
						title.setText(c.getTitle());
						content.setText(c.getText());
						if(c.getPicture()!=null){
							pic.setImageBitmap(c.getPicture());
						}
					}
					
				};
				
				activity.runOnUiThread(editSetup);
			}
		};
		
		thread.start();
	}
	
	/**
	 * Update a edited comment in to the server.
	 * @param commentId
	 * @param newTitle
	 * @param newContent
	 */
	public void commit_edit_comment(final String commentId,final String newTitle,final String newContent){
		Thread thread=new Thread(){
			@Override
			public void run(){
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
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				Comment c=Data.getSource();
				c.setTitle(newTitle);
				c.setText(newContent);
				commitUpdateComment(c);
			}
		};
		thread.start();
	}
	
	/**
	 * Load a comment specified by id as favorite and store the comment and all its replies in to the sharedpreferences. with key "FAVOURITES"
	 * @param commentId
	 * @param cc
	 * @param activity
	 */
	public void loadSpecificCommentForCache(final String commentId,final CacheController cc,final CommentPageActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
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
					while (output != null) {
						responseJson+= output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				
				Runnable getComment = new Runnable() {
					@Override
					public void run() {
						Comment c=Data.getSource();
						if(c!=null){
							cc.AddFav(activity,c);
							String id=c.getId();
							for(String replyId : c.getReplies()){
								loadSpecificCommentForCacheReply(replyId,id,cc,activity);
							}
							Toast.makeText(activity.getApplicationContext(),"Like Success.",Toast.LENGTH_SHORT).show();
						}
					}
				};
				activity.runOnUiThread(getComment);
			}
		};
		thread.start();
	}
	
	/**
	 * Load a comment for cache ,store it in the sharedpreferences with the key value equals to this comment's parent Id.
	 * @param commentId
	 * @param parentId
	 * @param cc
	 * @param activity
	 */
	public void loadSpecificCommentForCacheReply(final String commentId,final String parentId,final CacheController cc,final CommentPageActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
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
					while (output != null) {
						responseJson+=output;
						output = reader.readLine();
					}
				} 
				catch (ClientProtocolException e){
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Comment>>(){}.getType();
				final ElasticSearchResponse<Comment> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				
				Runnable getCacheReply = new Runnable() {
					@Override
					public void run() {
						Comment c=Data.getSource();
						String id=c.getId();
						if(c!=null){
							cc.AddCacheReply(activity,parentId,c);
							for(String replyId : c.getReplies()){
								loadSpecificCommentForCacheReply(replyId,id,cc,activity);
							}
						}
					}
				};
				activity.runOnUiThread(getCacheReply);
			}
		};
		thread.start();
	}
	
	/**
	 * testing method used to trash all stuff on the server.
	 */
	public void Clean(){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpDelete request = new HttpDelete(SERVER_URL);
				HttpResponse response=null;
				try{
					response = client.execute(request);
					Log.i(LOG_TAG, "Clean: " + response.getStatusLine().toString());
				}
				catch(IOException exception){
					Log.w(LOG_TAG, "Error during Clean: " + exception.getMessage());
				}
			}
		};
		thread.start();
	}
}
