package network_io;

import model.User;

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
				
			}
		};
	}
}
