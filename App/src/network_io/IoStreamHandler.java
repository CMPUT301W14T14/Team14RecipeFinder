package network_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import model.Comment;
import model.CommentMap;
import model.IdSet;

import android.app.Activity;
import android.location.Location;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cache.CacheController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import customlized_gson.GsonConstructor;



/**
 * A network controller used to get and update comment from/to the server.
 * Adapted From https://github.com/zjullion/PicPosterComplete/blob/master/src/ca/ualberta/cs/picposter/network/ElasticSearchOperations.java
 */
public class IoStreamHandler {
	
	public static final String SERVER_URL="http://cmput301.softwareprocess.es:8080/cmput301w14t14/";
	public static final String LOG_TAG="Elastic Search";
	
	private Gson gson=(new GsonConstructor()).getGson();
	
	public IoStreamHandler(){}
	
	/**
	 * Update a comment with its own id to the web server, if the comment with the same id doesn't exist, then this comment will be added to the server.
	 * @param comment a single comment object.
	 */
	public Thread addOrUpdateComment(final Comment comment){
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
		return thread;
	}
	
	
	/**
	 * Put a Comment with the specific id into the CommentMap from the web server in the HomePageActivity(top level).
	 * @param commentID a String which is the comment id.
	 * @param commentMap a CommentMap to be update.
	 * @param activity Activity where the function will be called.
	 */
	
	public Thread loadSpecificComment(final String commentID,final CommentMap commentMap,final Activity activity){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+commentID+"/");
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
						Comment comment=Data.getSource();
						if(comment!=null){
							commentMap.addComment(comment);
						}
					}
				};
				activity.runOnUiThread(getComment);
			}
		};
		thread.start();
		return thread;
	}
	
	/**
	 * Update the top level comment's IdSet which stored in the server, if there's nothing in the server, then add it to the server.
	 * @param topLevelIdSet top level comment's IdSet.
	 */
	
	public Thread updateTopLevelIdSet(final IdSet idSet){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpPut request = new HttpPut(SERVER_URL+"IdSet/topLevelId/");
				try {
					request.setEntity(new StringEntity(gson.toJson(idSet)));
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
		return thread;
	}
	
	/**
	 * Load all of the top level comments in to the CommentMap.
	 * @param commentMap a CommentMap.
	 * @param activity Activity where the function will be called.
	 */
	public Thread loadTopLevelComments(final CommentMap commentMap,final Activity activity){
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
						loadSpecificComment(id,commentMap,activity);
					}
				}
			}
		};
		thread.start();
		return thread;
	}
	
	/**
	 * Add a comment id to the top level IdSet and update the IdSet in the server while publish a new top level comment.
	 * @param commentID a String which is the comment id to be add to the IdSet.
	 * @param activity PublishActivity where the function will be called.
	 */
	
	public Thread loadAndUpdateTopLevelIdSet(final String commentID,final Activity activity){
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
						responseJson+=output;
						output = reader.readLine();
					}
				}
				catch (ClientProtocolException e) {
					e.printStackTrace();
				} 
				catch (IOException e){
					Log.w(LOG_TAG, "Error receiving query response: " + e.getMessage());
					e.printStackTrace();
				}
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<IdSet>>(){}.getType();
				final ElasticSearchResponse<IdSet> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				Runnable updateIdSet = new Runnable() {
					@Override
					public void run() {
						IdSet idSet=Data.getSource();
						if(idSet==null){
							idSet=new IdSet();
						}
						idSet.add(commentID);
						updateTopLevelIdSet(idSet);
					}
				};
				activity.runOnUiThread(updateIdSet);
			}
		};
		thread.start();
		return thread;
	}
	
	public Thread loadAndSetSpecificComment(final String commentID,final TextView title,final TextView content,final TextView commentInfo,final ImageView picture,final CommentMap commentMap,final Activity activity){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+commentID+"/");
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
						Comment comment=Data.getSource();
						if(comment!=null){
							title.setText(comment.getTitle());
							content.setText(comment.getText());
							picture.setImageBitmap(comment.getPicture());
							Location location=comment.getLocation();
							if(location!=null){
								double lat=location.getLatitude();
								double lng=location.getLongitude();
								String lngS=String.valueOf(lng);
								String latS=String.valueOf(lat);
								commentInfo.setText("Posted By : "+comment.getUserName()+"\nAt : "+((new Date(comment.getTimePosted())).toString())+"\nLongitude: "+lngS+"\nLatitude: "+latS);
							}
							else{
								commentInfo.setText("Posted By : "+comment.getUserName()+"\nAt : "+((new Date(comment.getTimePosted())).toString()));
							}
							for(String commentIDs : comment.getReplies()){
								loadSpecificComment(commentIDs,commentMap,activity);
							}
						}
					}
				};
				activity.runOnUiThread(getAndSetComment);
			}
		};
		thread.start();
		return thread;
	}
	
	/**
	 * Load a specific Comment by it's id and add an reply Comment's id to this comment's reply IdSet.
	 * @param commentId a String which is the comment id of the comment has been replied.
	 * @param replyId a String which is the comment id of the reply comment.
	 */
	public Thread replySpecificComment(final String parentID,final String replyID){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+parentID+"/");
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
				Comment parent=Data.getSource();
				parent.addReply(replyID);
				addOrUpdateComment(parent);
			}
		};
		thread.start();
		return thread;
	}
	
	public Thread setupEditPage(final String commentID,final EditText title,final EditText content,final EditText latitude,final EditText longitude,final ImageView picture,final Activity activity){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+commentID+"/");
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
				Runnable getAndSetEditComment = new Runnable(){
					@Override
					public void run(){
						Comment comment=Data.getSource();
						title.setText(comment.getTitle());
						content.setText(comment.getText());
						Location loc=comment.getLocation();
						if(loc!=null){
							latitude.setText(String.valueOf(loc.getLatitude()));
							longitude.setText(String.valueOf(loc.getLongitude()));
						}
						picture.setImageBitmap(comment.getPicture());
					}
					
				};
				activity.runOnUiThread(getAndSetEditComment);
			}
		};
		thread.start();
		return thread;
	}
	

	/**
	 * Update a edited comment in to the server.
	 * @param commentID a String which is commentId
	 * @param editedTitle a String which is the title of the comment after edit.
	 * @param editedText a String which is the content of the comment after edit.
	 */
	public Thread commitEdit(final String commentID,final String editedTitle,final String editedText,final Location editedLocation,final Activity activity){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+commentID+"/");
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
				Comment comment=Data.getSource();
				comment.setTitle(editedTitle);
				comment.setText(editedText);
				comment.setLocation(editedLocation);
				addOrUpdateComment(comment);
			}
		};
		thread.start();
		return thread;
	}
	
	/**
	 * Load a comment for cache ,store it in the shared preferences with the key value equals to this comment's parent Id.
	 * @param commentID a String which is the comment id.
	 * @param parentID a String which is the parent comment id.
	 * @param cc a CacheController object.
	 * @param activity Activity where the function will be called.
	 */
	public Thread addCache(final String commentID,final String parentID,final CacheController cc,final String tag,final Activity activity){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"Comment/"+commentID+"/");
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
				
				Runnable putCacheReply = new Runnable() {
					@Override
					public void run() {
						Comment comment=Data.getSource();
						if(!tag.equals("reply")){
							cc.addCacheAsTopLevel(activity,comment,tag);
						}
						else{
							cc.addCacheAsReply(activity,parentID,comment);
						}
						for(String replyID : comment.getReplies()){
							addCache(replyID,comment.getId(),cc,"reply",activity);
						}
					}
				};
				activity.runOnUiThread(putCacheReply);
			}
		};
		thread.start();
		return thread;
	}
	
	
	public void clean(){
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
