package customlized_gson;

import android.graphics.Bitmap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A class able to Constructs a Gson with a custom serializer / desserializer registered for Bitmaps.
 * getted from https://github.com/zjullion/PicPosterComplete/blob/master/src/ca/ualberta/cs/picposter/network/ElasticSearchOperations.java
 */
public class Gson_Constructor {
	public Gson_Constructor(){}
	/**
	 * 
	 * @return a Gson with a custom serializer / desserializer registered for Bitmaps.
	 */
	public Gson getGson(){
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Bitmap.class,new Bitmap_Converter());
		return builder.create();
	}
}
