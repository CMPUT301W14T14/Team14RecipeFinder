package network_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import model.UserProfile;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import customlized_gson.GsonConstructor;


public class ProfileIoHandler{
	public static final String SERVER_URL="http://cmput301.softwareprocess.es:8080/cmput301w14t14/";
	public static final String LOG_TAG="Elastic Search";
	
	private Gson gson=(new GsonConstructor()).getGson();
	
	public ProfileIoHandler(){}
	
	public Thread putOrUpdateProfile(final UserProfile profile){
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpPut request = new HttpPut(SERVER_URL+"UserProfile/"+profile.getUserName()+"/");
				try{
					request.setEntity(new StringEntity(gson.toJson(profile)));
				}
				catch(UnsupportedEncodingException exception){
					Log.w(LOG_TAG, "Error during Encoding: " + exception.getMessage());
					return;
				}
				
				HttpResponse response=null;
				try{
					response = client.execute(request);
					Log.i(LOG_TAG, "ProfileUpdate: " + response.getStatusLine().toString());
				}
				catch(IOException exception){
					Log.w(LOG_TAG, "Error during Update: " + exception.getMessage());
				}
			}
		};
		thread.start();
		return thread;
	}
	
	
	public Thread loadSpecificProfileForUpdate(final String userName,final Activity activity,final ImageButton photo,
			final EditText userNameInput,final EditText biographyInput,final EditText twitterInput,final EditText facebookInput){
		
		Thread thread=new Thread(){
			@Override
			public void run(){
				HttpClient client=new DefaultHttpClient();
				HttpGet request = new HttpGet(SERVER_URL+"UserProfile/"+userName+"/");
				HttpResponse response=null;
				String responseJson = "";
				try{
					response=client.execute(request);
					Log.i(LOG_TAG, "ProfileLoad: " + response.getStatusLine().toString());
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
				
				Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<UserProfile>>(){}.getType();
				final ElasticSearchResponse<UserProfile> Data = gson.fromJson(responseJson,elasticSearchResponseType);
				
				Runnable getProfile = new Runnable() {
					@Override
					public void run() {
						UserProfile loadedProfile=Data.getSource();
						userNameInput.setText(userName);
						if(loadedProfile!=null){
							photo.setImageBitmap(loadedProfile.getPhoto());
							biographyInput.setText(loadedProfile.getBiography());
							twitterInput.setText(loadedProfile.getTwitter());
							facebookInput.setText(loadedProfile.getFacebook());
						}
					}
				};
				activity.runOnUiThread(getProfile);
			}
		};
		thread.start();
		return thread;
	}
}
