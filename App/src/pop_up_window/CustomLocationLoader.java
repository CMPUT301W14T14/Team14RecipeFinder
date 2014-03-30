package pop_up_window;

import gps.LocationGenerator;
import adapter.ListViewAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectapp.R;


public class CustomLocationLoader{
	
	public CustomLocationLoader(){}
	
	public void loadWindow(final TextView newLocation,final ListViewAdapter listViewAdapter,final LocationGenerator locationGenerator,final Context context,final Activity activity){
		// get prompts.xml view
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		View promptsView = layoutInflater.inflate(R.layout.prompt_for_location, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

		// set prompts.xml to alertDialog builder
		alertDialogBuilder.setView(promptsView);

		final EditText lat = (EditText) promptsView.findViewById(R.id.new_latitude);
		final EditText lng = (EditText) promptsView.findViewById(R.id.new_longitude);

		// set dialog message
		alertDialogBuilder.setCancelable(false).setPositiveButton("OK",new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog,int id) {
				// get user input location
				String newLatitude = lat.getText().toString();
				String newLongitude = lng.getText().toString();
				
				try{
					Location customLocation=locationGenerator.getCustomLocation(Double.parseDouble(newLatitude),Double.parseDouble(newLongitude));
					if(customLocation==null){
						throw new Exception();
					}
					newLocation.setText("Custom sorting location: " + newLatitude + ", " + newLongitude);
					listViewAdapter.setSortingLocation(customLocation);
					listViewAdapter.notifyDataSetChanged();
				}
				catch(Exception e){
					Toast.makeText(activity.getApplicationContext(),"GPS is not functional or invalid input for location, cannot sort.",Toast.LENGTH_SHORT).show();
				}
				
			}
			
			
		}).setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog,int id) {
				dialog.cancel();
			}
			
		});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}
}
