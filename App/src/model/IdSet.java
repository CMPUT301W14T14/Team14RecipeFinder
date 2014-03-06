package model;

import java.util.ArrayList;
import java.util.Collection;


public class IdSet{
	private ArrayList<String> set=null;
	
	public IdSet(){
		this.set=new ArrayList<String>();
	}
	
	public ArrayList<String> getSet(){
		return this.set;
	}
	
	public void add(String id){
		this.set.add(id);
	}
	
	public void addAll(Collection<String> c){
		this.set.addAll(c);
	}
	
	public void clear(){
		this.set.clear();
	}

}
