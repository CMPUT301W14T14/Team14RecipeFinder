package activity;

import model.CommentList;

import cache.CacheController;

import com.example.projectapp.R;


import adapter.ListViewAdapter;
import android.os.Bundle;
import android.widget.ListView;
//import android.widget.Button;

import android.app.Activity;

//Just for test right now!
public class ViewCacheActivity extends Activity {
	
	private ListView cacheView=null;
	
	private CommentList cl=null;
	private CacheController cc=null;
	private ListViewAdapter lva=null;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		cacheView=(ListView)findViewById(R.id.cacheView);
		cl=new CommentList();
		cc=new CacheController();
	}

	@Override
	protected void onResume(){
		super.onResume();
		cl=cc.loadFav(this);
		lva=new ListViewAdapter(this,R.layout.single_comment_layout,cl.getCurrentList());
		cacheView.setAdapter(lva);
	}
    
    
}
