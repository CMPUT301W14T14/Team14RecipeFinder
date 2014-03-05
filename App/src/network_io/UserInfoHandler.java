package network_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import model.User;

import activity.LoginViewActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import controller.UserInfoController;

import customlized_gson.Gson_Constructor;

//Don't modify, NOT DONE!
public class UserInfoHandler {
	public static final String SERVER_URL="http://cmput301.softwareprocess.es:8080/cmput301w14t14/";
	public static final String LOG_TAG="Elastic Search";
	private static Gson gson=null;
	
	public UserInfoHandler(){}
	
	public void commitUpdateUserInfo(final User user){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpPut request = new HttpPut(SERVER_URL+"User/"+user.getUserName()+"/");
				try {
					request.setEntity(new StringEntity(gson.toJson(user)));
				} 
				catch (UnsupportedEncodingException e) {
					Log.w(LOG_TAG, "Error during Encoding: " + e.getMessage());
					e.printStackTrace();
					return;
				}
				
				HttpResponse response=null;
				
				try {
					response=client.execute(request);
					Log.i(LOG_TAG, "Response: " + response.getStatusLine().toString());
				} 
				catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
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
	
	public void getUserInfo(final String userName,final UserInfoController uic,final LoginViewActivity activity){
		if(gson==null){
			gson=(new Gson_Constructor()).getGson();
		}
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client =new DefaultHttpClient();
				HttpGet request=new HttpGet(SERVER_URL+"User/"+userName+"/");
				HttpResponse response=null;
				String responseJson = "";
				try {
					response=client.execute(request);
					Log.i(LOG_TAG, "Response: " + response.getStatusLine().toString());
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
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<User>>(){}.getType();
				final ElasticSearchResponse<User> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				Runnable getUserInfo = new Runnable(){

					@Override
					public void run() {
						User user=Data.getSource();
						if(user!=null){
							uic.setUser(user);
						}
						else{
							uic.setUser(new User(userName));
						}
					}
					
				};
				activity.runOnUiThread(getUserInfo);
			}
		};
		thread.start();
	}
}
