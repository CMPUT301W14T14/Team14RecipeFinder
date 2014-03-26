package ca.ualberta.cs.myapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathMap {
	
	private Map<String,Math> maths=null;
	private ArrayList<Math> math_list=null;
	
	public MathMap(){
		this.maths=new HashMap<String,Math>();
		this.math_list=new ArrayList<Math>();
	}

	public void updateMath(Math math){
		this.maths.put(math.getNum()+"",math);
		this.math_list.add(math);
	}
	
	public Math getMath(String id){
		return this.maths.get(id);
	}
	
	public List<Math> getCurrentList(){
		return Collections.unmodifiableList(this.math_list);
	}
}
