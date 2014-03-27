package user_name;

import android.content.SharedPreferences;


public class UserNameHandler{
	
	public static final String USER_NAME_KEY="userNameKey";
	
	public UserNameHandler(){}
	
	public String getUserName(SharedPreferences caches){
		String userName=caches.getString(USER_NAME_KEY, null);
		return userName;
	}
	
	public void setUserName(SharedPreferences caches,String userName){
		caches.edit().putString(USER_NAME_KEY,userName).commit();
	}
	
	public void emptyUserName(SharedPreferences caches){
		caches.edit().remove(USER_NAME_KEY);
	}
}
