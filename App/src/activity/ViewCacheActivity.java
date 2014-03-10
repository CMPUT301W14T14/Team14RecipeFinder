package activity;

import model.CommentMap;

import cache.CacheController;

import com.example.projectapp.R;

import adapter.ListViewAdapter;
import android.os.Bundle;
//import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class ViewCacheActivity extends Activity {
	
	private TextView pageName=null;
	private ListView cacheView=null;
	//private Button sort=null;
	
	private String TAG=null;
	private CommentMap cm=null;
	private ListViewAdapter lva=null;
	private CacheController cc=null;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		pageName=(TextView)findViewById(R.id.pagename);
		cacheView=(ListView)findViewById(R.id.cacheView);
		cc=new CacheController();
		
		cm=new CommentMap();
		lva=new ListViewAdapter(this,R.layout.single_comment_layout,cm.getCurrentList());
		cacheView.setAdapter(lva);
		cm.setArrayAdapter(lva);
	}

	@Override
	protected void onResume(){
		super.onResume();
		Intent intent=getIntent();
		TAG=intent.getStringExtra("TAG");
		if(TAG.equals("FAV")){
			pageName.setText("My Favourites: ");
			cm=cc.loadFav(this);
		}
	}
    
    
}
