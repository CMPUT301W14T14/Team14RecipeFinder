package model;

import java.util.ArrayList;


public class CommentPath{
	private ArrayList<MapNode> map=null;
	
	public CommentPath(){
		this.map=new ArrayList<MapNode>();
	}
	
	public void addNode(MapNode newNode){
		this.map.add(newNode);
	}
	
	public ArrayList<MapNode> getMap(){
		return this.map;
	}
	
	public Integer getDepth(){
		return this.map.size();
	}
}
