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

/**
 * An Activity allows user view his own profile including guest.
 * @author xuping
 */
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
	/**
	 * Direct user to the page which can reset the userName(ReserUserNameActivity).
	 * @author xuping
	 */
	class ResetNameClick implements OnClickListener{

		@Override
		public void onClick(View v){
			Intent push_intent=new Intent(UserInfoPageActivity.this,ResetUserNameActivity.class);
			startActivity(push_intent);
		}
		
	}
	/**
	 * Direct user to the page which can view the comment as favorites locally.
	 * @author xuping
	 */
	class FavClick implements OnClickListener{

		@Override
		public void onClick(View v){
			Intent push_intent=new Intent(UserInfoPageActivity.this,ViewFavActivity.class);
			push_intent.putExtra("TAG","FAV");
			startActivity(push_intent);
		}
		
	}
}
