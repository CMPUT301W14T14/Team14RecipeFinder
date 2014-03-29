package network_io;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class ConnectionChecker{
	
	public ConnectionChecker(){}
	/**
	 * Adapted from http://stackoverflow.com/questions/9570237/android-check-internet-connection
	 * @param activity
	 * @return
	 */
	public boolean isNetworkOnline(Activity activity) {
		ConnectivityManager cm = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if(ni==null){
			return false;
		}
		return ni.isConnected();
	}  
}
