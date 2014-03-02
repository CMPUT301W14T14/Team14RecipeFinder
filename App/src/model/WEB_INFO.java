package model;

public class WEB_INFO {
	private final String SERVER_URL="http://cmput301.softwareprocess.es:8080/cmput301w14t14/";
	private final String LOG_TAG="ioFlow";
	
	public WEB_INFO(){}
	
	public String getServerUrl(){
		return this.SERVER_URL;
	}
	
	public String getLogTag(){
		return this.LOG_TAG;
	}
}
