package comparator;

import java.util.Comparator;

import model.Comment;

public class TimeComparator implements Comparator<Comment>{

	@Override
	public int compare(Comment a, Comment b) {
		// TODO Auto-generated method stub
		if(a.getTimePosted()>=b.getTimePosted()){
			return 1;
		}
		else{
			return 0;
		}
	}
	
}
