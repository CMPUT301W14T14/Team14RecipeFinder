package controller;


import com.example.projectapp.R;

import adapter.ListViewAdapter;
import android.content.Context;

import model.CommentMap;
import model.UserMap;


public class AdapterConstructor{
	private Context context=null;
	
	public AdapterConstructor(Context context){
		this.context=context;
	}
	
	public ListViewAdapter getAdapterNotSorted(CommentMap updatedCommentMap,UserMap updatedUserMap){
		return new ListViewAdapter(this.context,R.layout.single_comment_layout,updatedCommentMap.getCurrentList(),updatedUserMap);
	}
}
