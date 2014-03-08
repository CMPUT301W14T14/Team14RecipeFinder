package gps;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;


public class Location_Generator{
	private LocationManager lm = null;
	private Location currentLocation=null;
	private LocationListener locationListener=null;
	
	public Location_Generator(LocationManager lm){
		this.lm=lm;
		this.locationListener=new LocationListener(){

			@Override
			public void onLocationChanged(Location location){
				if(location!=null){
					System.out.println("Location Changed");
				}
				else{
					System.out.println("Error: can not get the location.");
				}
			}

			@Override
			public void onProviderDisabled(String provider){}

			@Override
			public void onProviderEnabled(String provider){}

			@Override
			public void onStatusChanged(String provider,int status,Bundle extras){}
			
		};
		this.lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,1,this.locationListener);
	}

	public Location getCurrentLocation(){
		this.currentLocation=this.lm.getLastKnownLocation("gps");
		return this.currentLocation;
	}
	
	public Location getCustomLocation(double latitude,double longitude){
		Location l=new Location(this.currentLocation);
		l.setLatitude(latitude);
		l.setLongitude(longitude);
		return l;
	}
	
}
