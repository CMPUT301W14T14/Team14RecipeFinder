package network_io;

import java.util.Timer;
import java.util.TimerTask;

import activity.AllTopicPageActivity;


public class NetworkObserver{
	
	private ConnectionChecker cc=new ConnectionChecker();
	 
	public NetworkObserver(){}
	
	public void startObservation(final AllTopicPageActivity activity){
		Thread thread=new Thread(){
			@Override
			public void run(){
				final Timer timer=new Timer();
				timer.schedule(new TimerTask() {

		            @Override
		            public void run() {
		            	if(cc.isNetworkOnline(activity)){
		            		timer.cancel();
		            		timer.purge();
		            		Runnable action= new Runnable(){
		            			@Override
		            			public void run(){
		            				activity.refresh();
		            			}
		            		};
		            		activity.runOnUiThread(action);
		            	}

		            }
		        }, 5000, 5000);
			}
		};
		thread.start();
	}
	
	public void setObserver(final AllTopicPageActivity activity){
		Thread thread=new Thread(){
			@Override
			public void run(){
				final Timer timer=new Timer();
				timer.schedule(new TimerTask() {

		            @Override
		            public void run() {
		            	if(cc.isNetworkOnline(activity)==false){
		            		timer.cancel();
		            		timer.purge();
		            		Runnable action= new Runnable(){
		            			@Override
		            			public void run(){
		            				activity.refresh();
		            			}
		            		};
		            		activity.runOnUiThread(action);
		            	}

		            }
		        }, 5000, 5000);
			}
		};
		thread.start();
	}
}
