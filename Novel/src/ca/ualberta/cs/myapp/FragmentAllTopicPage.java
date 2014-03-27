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
		
		mView = inflater.inflate(R.layout.fragment_all_topic, null);

		
		MathMap maths = new MathMap();
		TestUIThread tt = new TestUIThread();
		tt.test(maths);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		maths = tt.getMathMap();
		
		Button button = (Button)mView.findViewById(R.id.dummy_button);

		if (maths.getCurrentList().isEmpty()) {
			button.setText("Empty");
			return mView;
		} 
//		else {
//			button.setText("NotEmpty");
//			int sum = maths.getMath(1+"").getNum()+maths.getMath(2+"").getNum()+maths.getMath(3+"").getNum();
//			button.setText(sum+"");
//			return mView;
//		}
		
//		button.setText(maths.getMath(0+"").getNum()+"");
//		button.setText(maths.getMath(1+"").getNum()+"");
//		button.setText(maths.getMath(2+"").getNum()+"");
		button.setText(maths.getMath(3+"").getNum()+"");
		
		return mView;
		
//		return inflater.inflate(R.layout.fragment_all_topic, null);
	}	
}
