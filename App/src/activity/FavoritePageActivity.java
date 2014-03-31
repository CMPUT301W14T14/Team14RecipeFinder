package activity;

import pop_up_window.CustomLocationLoader;
import gps.LocationGenerator;
import model.Comment;
import model.CommentList;

import cache.CacheController;

import com.example.projectapp.R;
import com.google.gson.Gson;

import customlized_gson.GsonConstructor;

import adapter.ListViewAdapter;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class FavoritePageActivity extends Activity implements OnItemSelectedListener {

	Spinner spinnerOsversions;
	
	private ListView listView = null;
	private CacheController cacheController=null;
	private CommentList list=null;
	private ListViewAdapter listViewAdapter=null;
	private LocationGenerator locationGenerator=null;
	
	private Gson gson=(new GsonConstructor()).getGson();
	
	private TextView favNewLocation=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorite_page);
		
		initView();
		
		listView = (ListView)findViewById(R.id.favorite_list);
		
		cacheController=new CacheController();
		Intent intent=getIntent();
		if(intent.getBooleanExtra("isFav",true)){
			list=cacheController.getResource(this,"fav");
		}
		else{
			list=cacheController.getResource(this,"indicated");
		}
		listViewAdapter=new ListViewAdapter(this,R.layout.single_comment_layout,list.getCurrentList());
		listView.setAdapter(listViewAdapter);
		
		listView.setOnItemClickListener(new FavViewClick());
		
		locationGenerator=new LocationGenerator((LocationManager)getSystemService(Context.LOCATION_SERVICE));
		
		favNewLocation=(TextView)findViewById(R.id.fav_new_location);
	}
	
	class FavViewClick implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3){
			Intent pushIntent=new Intent(FavoritePageActivity.this,LocalCommentPageActivity.class);
			pushIntent.putExtra("commentJson",gson.toJson((Comment)arg0.getItemAtPosition(pos)));
			startActivity(pushIntent);
		}
		
	}
	
	/**
	 * Initialize View. First, get ActionBar to enable title and disable title.
	 * Second, initialize spinner for sort options
	 */
	private void initView() {
		// ActionBar
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

		// Spinner for sort options
		spinnerOsversions = (Spinner) findViewById(R.id.fav_spinner);
		ArrayAdapter<String> sortArray = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, AllTopicPageActivity.sortOption);
		sortArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerOsversions.setAdapter(sortArray);
		spinnerOsversions.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.favorite_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {

		case R.id.action_profile:
			intent = new Intent(this,ProfilePageActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
		favNewLocation.setText("");
		spinnerOsversions.setSelection(position);
		String sortSelect = (String) spinnerOsversions.getSelectedItem();

		if (sortSelect == AllTopicPageActivity.sortByDate) {
			listViewAdapter.setSortingOption(ListViewAdapter.SORT_BY_TIME);
		} 
		else if (sortSelect == AllTopicPageActivity.sortByMyLocation) {
			Location currentLocation=locationGenerator.getCurrentLocation();
			if(currentLocation==null){
				Toast.makeText(getApplicationContext(),"GPS is not functional, cannot sort.",Toast.LENGTH_SHORT).show();
			}
			else{
				listViewAdapter.setSortingLocation(currentLocation);
			}
		} 
		else if (sortSelect == AllTopicPageActivity.sortByOtherLocation) {
			(new CustomLocationLoader()).loadWindow(favNewLocation,listViewAdapter,locationGenerator,this,this);
		} 
		else if (sortSelect == AllTopicPageActivity.sortByPicture) {
			listViewAdapter.setSortingOption(ListViewAdapter.SORT_BY_PIC);
		}
		else if(sortSelect == AllTopicPageActivity.sortByDefault){
			Location currentLocation=locationGenerator.getCurrentLocation();
			if(currentLocation==null){
				Toast.makeText(getApplicationContext(),"GPS is not functional, cannot sort by deafult.",Toast.LENGTH_SHORT).show();
			}
			else{
				listViewAdapter.sortByDefault(currentLocation);
			}
		}
		listViewAdapter.notifyDataSetChanged();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

}
