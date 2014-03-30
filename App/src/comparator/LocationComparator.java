package comparator;

import java.util.Comparator;

import android.location.Location;

import model.Comment;


public class LocationComparator implements Comparator<Comment>{
	
	private Location center=null;
	
	public LocationComparator(Location location){
		this.center=location;
	}

	@Override
	public int compare(Comment a, Comment b){
		if(a.getLocation()==null && b.getLocation()==null){
			return 0;
		}
		else if (a.getLocation()!=null && b.getLocation()==null){
			return -1;
		}
		else if(a.getLocation()==null && b.getLocation()!=null){
			return 1;
		}
		else if(center.distanceTo(a.getLocation())>=center.distanceTo(b.getLocation())){
			return 1;
		}
		else{
			return -1;
		}
	}
}
