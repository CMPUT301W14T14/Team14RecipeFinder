package comparator;

import java.util.Collections;
import java.util.List;

import model.Comment;


public class MainComparator{
	
	private TimeComparator timeCmp=new TimeComparator();
	private PictureComparator picCmp=new PictureComparator();
	
	public MainComparator(){}
	
	public List<Comment> getTimeSortedList(List<Comment> list){
		Collections.sort(list,timeCmp);
		return list;
	}
	
	public List<Comment> getPictureSortedList(List<Comment> list){
		Collections.sort(list,picCmp);
		return list;
	}
}
