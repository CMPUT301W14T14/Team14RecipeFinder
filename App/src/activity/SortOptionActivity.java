package activity;

import com.example.projectapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
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
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sort_option, menu);
		return true;
	}

}
