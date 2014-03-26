package ca.ualberta.cs.myapp;

import com.example.myapp.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentAllTopicPage extends Fragment{
	
	private View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
//		Button button = (Button)findViewById(R.id.dummy_button);
		mView = inflater.inflate(R.layout.fragment_all_topic, null);
		
//		MainActivity main = (MainActivity)getActivity();
//		Math ma = main.math;
		
		MathMap maths = new MathMap();
		TestUIThread tt = new TestUIThread();
		tt.test(maths);
		
//		Thread thread = new Thread();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		maths = tt.getMathMap();
		
		Button button = (Button)mView.findViewById(R.id.dummy_button);
		
//		button.
		if (maths.getCurrentList().isEmpty()) {
			button.setText("Empty");
			return mView;
		} else {
//			button.setText("NotEmpty");
			int sum = maths.getMath(1+"").getNum()+maths.getMath(2+"").getNum()+maths.getMath(3+"").getNum();
			button.setText(sum+"");
			return mView;
		}
//		button.setText(maths.getMath(0+"").getNum()+"");
//		button.setText(maths.getMath(1+"").getNum()+"");
//		button.setText(maths.getMath(2+"").getNum()+"");
//		button.setText(maths.getMath(3+"").getNum()+"");
		
//		return mView;
		
//		return inflater.inflate(R.layout.fragment_all_topic, null);
	}	
}
