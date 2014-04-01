package network_io;

import java.util.Timer;
import java.util.TimerTask;

import activity.AllTopicPageActivity;
import activity.CommentPageActivity;


public class NetworkObserver{
	
	private ConnectionChecker cc=new ConnectionChecker();
	
	private Boolean observationStarted=null;
	 
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
		if(observationStarted==null || !observationStarted){
			thread.start();
			observationStarted=true;
		}
	}
	
	public void startObservation(final CommentPageActivity activity){
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
		if(observationStarted==null || !observationStarted){
			thread.start();
			observationStarted=true;
		}
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
		if(observationStarted==null || observationStarted){
			thread.start();
			observationStarted=false;
		}
	}
	
	public void setObserver(final CommentPageActivity activity){
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
		if(observationStarted==null || observationStarted){
			thread.start();
			observationStarted=false;
		}
	}
}
