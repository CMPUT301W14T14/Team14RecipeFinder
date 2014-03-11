package activity;

import com.example.projectapp.R;
import com.example.projectapp.UserNameInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class UserInfoPageActivity extends Activity {
	private TextView userName=null;
	//private Button laterList=null;
	private Button favourite=null;
	//private Button historyTopic=null;
	private Button setName=null;
	
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	 	super.onCreate(savedInstanceState);
	    setContentView(R.layout.userinfopage);
	    userName=(TextView)findViewById(R.id.usernameView);
	    favourite=(Button)findViewById(R.id.favourite);
	    setName=(Button)findViewById(R.id.setname);
	}

	@Override
	protected void onResume(){
		super.onResume();
		userName.setText(((UserNameInfo)this.getApplication()).getUserName());
		favourite.setOnClickListener(new FavClick());
		setName.setOnClickListener(new ResetNameClick());
	}
	
	class ResetNameClick implements OnClickListener{

		@Override
		public void onClick(View v){
			Intent push_intent=new Intent(UserInfoPageActivity.this,ResetUserNameActivity.class);
			startActivity(push_intent);
		}
		
	}
	
	class FavClick implements OnClickListener{

		@Override
		public void onClick(View v){
			Intent push_intent=new Intent(UserInfoPageActivity.this,ViewCacheActivity.class);
			push_intent.putExtra("TAG","FAV");
			startActivity(push_intent);
		}
		
	}
}
