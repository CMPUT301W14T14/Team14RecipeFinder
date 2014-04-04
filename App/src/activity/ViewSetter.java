package activity;

import com.example.projectapp.R;

import android.app.ActionBar;
import android.app.Activity;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ViewSetter{
	
	public ViewSetter(){}
	
	public void setView(Activity activity,Spinner spinnerOsversions,String tag){
		final ActionBar actionBar = activity.getActionBar();
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

		// Spinner for sort options
		if(tag.equals("ALL_TOPIC")){
			spinnerOsversions = (Spinner)activity.findViewById(R.id.all_topic_spinner);
		}
		else if(tag.equals("COMMENT_PAGE")){
			spinnerOsversions = (Spinner)activity.findViewById(R.id.comment_spinner);
		}
		else if(tag.equals("FAVORITES")){
			spinnerOsversions = (Spinner)activity.findViewById(R.id.fav_spinner);
		}
		else if(tag.equals("LOCAL_COMMENT")){
			spinnerOsversions = (Spinner)activity.findViewById(R.id.local_comment_spinner);
		}
		
		ArrayAdapter<String> sortArray = new ArrayAdapter<String>(activity,android.R.layout.simple_spinner_item, AllTopicPageActivity.sortOption);
		sortArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerOsversions.setAdapter(sortArray);
		spinnerOsversions.setOnItemSelectedListener((OnItemSelectedListener)activity);
	}
}
