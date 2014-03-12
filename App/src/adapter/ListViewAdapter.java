package adapter;

import java.util.Date;
import java.util.List;

import com.example.projectapp.R;

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
public class ListViewAdapter extends ArrayAdapter<Comment>{

	public ListViewAdapter(Context context,int textViewResourceId,List<Comment> objects) {
		super(context,textViewResourceId,objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(this.getContext());
			convertView = inflater.inflate(R.layout.single_comment_layout, null);
		}
		Comment c = this.getItem(position);
		
		if(c!=null){
			ImageView comment_pic=(ImageView)convertView.findViewById(R.id.comment_pic);
			if(c.getPicture()!=null){
				comment_pic.setImageBitmap(c.getPicture());
			}
			else{
				comment_pic.setImageBitmap(null);
			}
			TextView comment_text=(TextView)convertView.findViewById(R.id.comment_text);
			comment_text.setText(c.getTitle());
			TextView comment_info=(TextView)convertView.findViewById(R.id.user_name_and_time_posted);
			//Location l=c.getLocation();
			//if(l!=null){
				//double lng=l.getLongitude();
				//double lat=l.getLatitude();
				//String lngS=String.valueOf(lng);
				//String latS=String.valueOf(lat);
				//comment_info.setText("Posted by: "+c.getUserName()+" At: "+(new Date(c.getTimePosted()).toString())+"\nLocation Longitude: "+lngS+"  Latitude: "+latS);
			//}
			//else{
				//comment_info.setText("Posted by: "+c.getUserName()+" At: "+(new Date(c.getTimePosted()).toString()));
			//}
			comment_info.setText("Posted by: "+c.getUserName()+" At: "+(new Date(c.getTimePosted()).toString()));
		}
		return convertView;
	}
	
}
