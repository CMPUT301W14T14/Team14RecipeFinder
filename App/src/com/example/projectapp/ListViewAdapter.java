package com.example.projectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

// This class is not done.
public class ListViewAdapter extends BaseAdapter{
	private Context context;
	private Comment[] comments;
	private static LayoutInflater inflater = null;
	
	public ListViewAdapter(Context context,Comment[] comments){
		this.context=context;
		this.comments=comments;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount(){

		return this.comments.length;
	}

	@Override
	public Object getItem(int position){

		return this.comments[position];
	}

	@Override
	public long getItemId(int position){

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View v=convertView;
		if(v==null){
			v = inflater.inflate(R.layout.single_comment_layout,null);
		}
		TextView commentText=(TextView)v.findViewById(R.id.comment_text);
		commentText.setText(this.comments[position].getText());
		return null;
	}
	
}
