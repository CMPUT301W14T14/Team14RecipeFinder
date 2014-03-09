package activity;

import com.example.projectapp.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ViewHistoryActivity extends Activity {
	
	private Button goBack = null;
	private Button sort = null;
	//private ListView list = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		goBack = (Button)findViewById(R.id.goback);
		sort = (Button)findViewById(R.id.sort3);
		//list = (ListView)findViewById(R.id.listView1);
		
	}
	
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		goBack.setOnClickListener(listener);
		sort.setOnClickListener(listener);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_history, menu);
		return true;
	}

	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button = (Button)v;
			switch (button.getId()){
			case R.id.goback:
				//go back Button click
				Intent intent_back = new Intent();
				intent_back.setClass(ViewHistoryActivity.this, UserInfoPageActivity.class);
				ViewHistoryActivity.this.startActivity(intent_back);
				break;
			case R.id.sort3:
				//sort Button click
				Intent intent_sort = new Intent();
				intent_sort.setClass(ViewHistoryActivity.this, SortOptionActivity.class);
				ViewHistoryActivity.this.startActivity(intent_sort);
				break;
			}
		}
	};
}
