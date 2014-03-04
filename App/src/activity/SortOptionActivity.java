package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SortOptionActivity extends Activity {
	private Button sortByLocation=null;
	private Button generalSort=null;
	private Button sortByAnotherLocation=null;
	private Button sortByPic=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sortoption);
		sortByLocation=(Button)findViewById(R.id.sortbylocation);
		generalSort=(Button)findViewById(R.id.generalsort);
		sortByAnotherLocation=(Button)findViewById(R.id.sortbyotherlocation);
		sortByPic=(Button)findViewById(R.id.sortbypicture);
	}
	
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sortByLocation.setOnClickListener(listener);
		generalSort.setOnClickListener(listener);
		sortByAnotherLocation.setOnClickListener(listener);
		sortByPic.setOnClickListener(listener);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sort_option, menu);
		return true;
	}

	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button = (Button)v;
			switch (button.getId()){
			case R.id.sortbylocation:
				// sort by location Button click
				
				break;
			case R.id.generalsort:
				//sort by score Button click
				
				break;
			case R.id.sortbyotherlocation:
				// sort by other location Button click
				
				break;
			case R.id.sortbypicture:
				//sort by picture Button click
				
				break;
			}
		}
	};
}
