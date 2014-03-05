package network_io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import model.User;

import android.util.Log;

import com.google.gson.Gson;

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
}
