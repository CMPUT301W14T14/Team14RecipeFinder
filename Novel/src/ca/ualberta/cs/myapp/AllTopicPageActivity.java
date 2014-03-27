package ca.ualberta.cs.myapp;

import com.example.myapp.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class AllTopicPageActivity extends Activity implements OnItemSelectedListener {

	Spinner spinnerOsversions;
	static String sortByDate = "Sort By Date";
	static String sortByMyLocation = "Sort By My Location";
	static String sortByOtherLocation = "Sort By Ohter Location";
	static String sortByPicture = "Sort By Picture";
	static String[] sortOption = { sortByDate, sortByMyLocation,
			sortByOtherLocation, sortByPicture };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//
		// Initialize View
		initView();

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
		spinnerOsversions = (Spinner) findViewById(R.id.welcome_button);
		ArrayAdapter<String> sortArray = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, sortOption);
		sortArray
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerOsversions.setAdapter(sortArray);
		spinnerOsversions.setOnItemSelectedListener(this);
	}

	// /**
	// * Initialize ActionBar
	// */
	// private void initView() {
	// // get ActionBar
	// final ActionBar actionBar = getActionBar();
	// // set navigation mode to tab
	// actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	// // enable Logo
	// actionBar.setDisplayUseLogoEnabled(true);
	// actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	// // add Tabs
	// actionBar.addTab(actionBar
	// .newTab()
	// .setText("All Topics")
	// .setTabListener(
	// new MyTabListener<FragmentAllTopicPage>(this,
	// FragmentAllTopicPage.class)));
	// actionBar.addTab(actionBar
	// .newTab()
	// .setText("Favorites")
	// .setTabListener(
	// new MyTabListener<FragmentFavoritePage>(this,
	// FragmentFavoritePage.class)));
	// actionBar.addTab(actionBar
	// .newTab()
	// .setText("My Comments")
	// .setTabListener(
	// new MyTabListener<FragmentMyCommentPage>(this,
	// FragmentMyCommentPage.class)));
	// }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {

		case R.id.action_create:
			intent = new Intent(this, CreateCommentPageActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_favorite:
			 intent = new Intent(this, FavoritePageActivity.class);
			 startActivity(intent);
			 return true;
		case R.id.action_my_comment:
			intent = new Intent(this, MyCommentPageActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_profile:
			intent = new Intent(this, ProfilePageActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		spinnerOsversions.setSelection(position);
		String sortSelect = (String) spinnerOsversions.getSelectedItem();

		if (sortSelect == sortByDate) {

		} else if (sortSelect == sortByMyLocation) {

		} else if (sortSelect == sortByOtherLocation) {

		} else if (sortSelect == sortByPicture) {

		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
