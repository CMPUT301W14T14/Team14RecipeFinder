package customed_gson;

import android.graphics.Bitmap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Gson_Constructor {
	public Gson_Constructor(){}
	
	public Gson getGson(){
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Bitmap.class,new Bitmap_Converter());
		return builder.create();
	}
}
