package comparator;

import java.util.Comparator;

import android.location.Location;

import model.Comment;


public class ScoreSystem implements Comparator<Comment>{
	
	private Location center=null;
	
	public ScoreSystem(Location location){
		this.center=location;
	}

	@Override
	public int compare(Comment a, Comment b){
		if(getScore(a)>=getScore(b)){
			return -1;
		}
		else{
			return 1;
		}
	}
	
	private long getScore(Comment comment){
		long timeScore=comment.getTimePosted()/1000000;
		long locationScore=0;
		
		if(comment.getLocation()!=null){
			locationScore=-(long)comment.getLocation().distanceTo(center);
		}
		return timeScore+locationScore;
	}

}
