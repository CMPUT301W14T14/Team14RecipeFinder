package activity;

import model.CommentList;
import cache.CacheController;

import com.example.projectapp.R;

import adapter.ListViewAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


public class UserHistoryActivity extends Activity implements OnItemSelectedListener{
	 Spinner spinnerOsversions;
	 TextView selVersion;
	 private String generalSort = "general sort";
	 private String mylocSort = "sort by my location";
	 private String imageSort = "sort by picture";
	 private String otherlocSort = "sort by other location";
	 
	 private String[] sortOption = { generalSort, mylocSort, imageSort, otherlocSort};
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);

		spinnerOsversions = (Spinner) findViewById(R.id.sorthistory);
		ArrayAdapter<String> sortArray = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, sortOption);
		sortArray
			.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerOsversions.setAdapter(sortArray);
		spinnerOsversions.setOnItemSelectedListener(this);
	}

	@Override
	protected void onResume(){
		super.onResume();
	}
    
    public void onItemSelected(AdapterView<?> parent, View view, int position,
    		   long id) {
    		  spinnerOsversions.setSelection(position);
    		  String sortSelect = (String) spinnerOsversions.getSelectedItem();
    		  
    		  if(sortSelect == generalSort){
    			  
    		  }
    		  else if(sortSelect == mylocSort){
    			  
    		  }
    		  else if(sortSelect == imageSort){
    			  
    		  }
    		  else if(sortSelect == otherlocSort){
    			  
    		  }
    		 }

    public void onNothingSelected(AdapterView<?> arg0) {
    	// TODO Auto-generated method stub

    }
}
