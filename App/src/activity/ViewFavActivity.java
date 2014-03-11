package activity;

import model.Comment;
import model.CommentList;

import cache.CacheController;

import com.example.projectapp.R;
import com.google.gson.Gson;

import customlized_gson.Gson_Constructor;


import adapter.ListViewAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
//import android.widget.Button;

import android.app.Activity;
import android.content.Intent;

//Just for test right now!
public class ViewFavActivity extends Activity {
	
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
	
	class ViewClick implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0,View arg1,int pos,long arg3){
			Comment c=(Comment)arg0.getItemAtPosition(pos);
			Intent view_intent=new Intent(ViewFavActivity.this,ViewCacheCommentActivity.class);
			Gson gson=(new Gson_Constructor()).getGson();
			view_intent.putExtra("comment",gson.toJson(c));
			startActivity(view_intent);
		}
		
	}
    
    
}
