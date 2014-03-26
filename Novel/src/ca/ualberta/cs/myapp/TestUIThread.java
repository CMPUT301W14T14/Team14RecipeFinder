package ca.ualberta.cs.myapp;

import android.app.Activity;
import android.support.v4.app.Fragment;

public class TestUIThread {
	
	MathMap mathMap = new MathMap();
	
	public TestUIThread(){}
	
	public void test (final MathMap maths) {
		Thread thread=new Thread(){
			@Override
			public void run(){

				Math math1 = new Math();
				math1.setNum(1);
				Math math2 = new Math();
				math2.setNum(2);
				Math math3 = new Math();
				math3.setNum(3);
				mathMap.updateMath(math1);
				mathMap.updateMath(math2);
				mathMap.updateMath(math3);
//				mathMap = maths;
//				Runnable getComment = new Runnable() {
//					@Override
//					public void run() {
//						math.add(3);
//					}
//				};
//				fragment.getActivity().runOnUiThread(getComment);
			}
		};
		thread.start();
//		return thread;
	}
	
	public MathMap getMathMap() {
		return mathMap;
	}

}
