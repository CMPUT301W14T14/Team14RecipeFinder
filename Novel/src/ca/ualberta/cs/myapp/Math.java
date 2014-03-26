package ca.ualberta.cs.myapp;

public class Math {
	
	private int mNum;
	
	public Math() {
		mNum = 0;
	}
	
	public Math(int a) {
		mNum = a;
	}
	
	public int getNum() {
		return mNum;
	}
	
	public void setNum(int a) {
		mNum = a;
	}
	
	public void inc() {
		mNum++;
	}
	
	public void add(int num) {
		mNum = mNum + num;
	}

}
