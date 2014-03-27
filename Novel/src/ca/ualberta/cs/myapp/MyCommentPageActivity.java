package ca.ualberta.cs.myapp;

import com.example.myapp.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MyCommentPageActivity extends Activity implements OnItemSelectedListener {

	Spinner spinnerOsversions;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorite_page);
		
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
				android.R.layout.simple_spinner_item, MainActivity.sortOption);
		sortArray
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

		case R.id.action_favorite:
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

		if (sortSelect == MainActivity.sortByDate) {

		} else if (sortSelect == MainActivity.sortByMyLocation) {

		} else if (sortSelect == MainActivity.sortByOtherLocation) {

		} else if (sortSelect == MainActivity.sortByPicture) {

		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
