package adapter;
import java.util.Date;
import java.util.List;

import com.example.projectapp.R;

import comparator.PictureComparator;
import comparator.TimeComparator;

import model.Comment;

import android.content.Context;
//import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// This class is not done.
/**
 * A List View Adapter which maps information from the comment model to the view
 * Adapted from https://github.com/XUPINGI/PicPosterComplete/blob/master/src/ca/ualberta/cs/picposter/view/PicPostModelAdapter.java
 */
public class ListViewAdapter extends ArrayAdapter<Comment>{
	
	private String sortingOption="default";
	
	public static final String SORT_BY_TIME="sortByTime";
	public static final String SORT_BY_PIC="sortByPicture";
	public static final String SORT_BY_LOC="sortByLocation";
	
	/**
	 * Construct a ListViewAdapter.
	 * @param context a Context.
	 * @param textViewResourceId id of the Layout.
	 * @param objects a list of the Comment objects.
	 */

	public ListViewAdapter(Context context,int textViewResourceId,List<Comment> objects) {
		super(context,textViewResourceId,objects);
	}
	/**
	 * Maps different components of the comment object to the views of the CustomListView layout.
	 * @param position of the Object in the list.
	 * @param convertView the view will be set.
	 * @param parent the parent view.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(this.getContext());
			convertView = inflater.inflate(R.layout.single_comment_layout, null);
		}
		Comment c = this.getItem(position);
		
		if(c!=null){
			ImageView comment_pic=(ImageView)convertView.findViewById(R.id.comment_pic);
			comment_pic.setImageBitmap(c.getPicture());
			TextView comment_text=(TextView)convertView.findViewById(R.id.comment_text);
			comment_text.setText(c.getTitle());
			TextView comment_info=(TextView)convertView.findViewById(R.id.user_name_and_time_posted);
			comment_info.setText("Posted by: "+c.getUserName()+" At: "+(new Date(c.getTimePosted()).toString()));
		}
		return convertView;
	}
	@Override
	public void notifyDataSetChanged(){
		
		this.setNotifyOnChange(false);
		
		if(sortingOption.equals(SORT_BY_TIME)){
			this.sort(new TimeComparator());
		}
		else if(sortingOption.equals(SORT_BY_PIC)){
			this.sort(new PictureComparator());
		}
		this.setNotifyOnChange(true);
		
		super.notifyDataSetChanged();
	}
	
	public void setSortingOption(String option){
		this.sortingOption=option;
	}
	
}
