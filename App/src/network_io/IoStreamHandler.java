package network_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import model.CommentList;

import android.util.Log;

import com.google.gson.Gson;

import customlized_gson.Gson_Constructor;

//Adapted From https://github.com/zjullion/PicPosterComplete/blob/master/src/ca/ualberta/cs/picposter/network/ElasticSearchOperations.java

public class IoStreamHandler { //This class is Not done
	public static final String SERVER_URL="http://cmput301.softwareprocess.es:8080/cmput301w14t14/";
	public static final String LOG_TAG="Elastic Search";
	public static final String index="ROOT_COMMENTS/";
	
	private static Gson gson=null;
	
	public IoStreamHandler(){}
	
	public void commitUpdate(final CommentList root){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpPut request = new HttpPut(SERVER_URL+index);
				try{
					request.setEntity(new StringEntity(gson.toJson(root)));
				}
				catch(UnsupportedEncodingException exception){
					Log.w(LOG_TAG, "Error during Encoding: " + exception.getMessage());
					return;
				}
				
				HttpResponse response=null;
				try{
					response = client.execute(request);
					Log.i(LOG_TAG, "Response: " + response.getStatusLine().toString());
				}
				catch(IOException exception){
					Log.w(LOG_TAG, "Error during Update: " + exception.getMessage());
				}
			}
		};
		thread.start();
	}
	
	public CommentList loadRoot(){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		String jsonString="";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(SERVER_URL+index);
		try {
			HttpResponse response=client.execute(request);
			HttpEntity entity = response.getEntity();
			BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
			String output = reader.readLine();
			while (output != null){
				jsonString+=output;
				output=reader.readLine();
			}
		} 
		catch (ClientProtocolException e){
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		CommentList updatedRoot=gson.fromJson(jsonString,CommentList.class);
		return updatedRoot;
	}
}
