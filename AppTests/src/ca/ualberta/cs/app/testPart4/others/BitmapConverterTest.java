/**
 * 
 */
package ca.ualberta.cs.app.testPart4.others;

import com.google.gson.JsonElement;

import customlized_gson.BitmapConverter;
import activity.AllTopicPageActivity;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for BitmapConverter.
 * 
 * @author Yilu Su
 *
 */
public class BitmapConverterTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	public BitmapConverterTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether the BitmapConverter can properly serialize and deserialize a bitmap <br>
	 * First, create a mockup bitmap. Serialize followed by deserialize, and then check.
	 */
	public void testLBitmapConverter() {
		Bitmap bitmap = Bitmap.createBitmap(10,10 ,Bitmap.Config.ARGB_8888);
		BitmapConverter bitmapConverter = new BitmapConverter();
		JsonElement jsonElement = bitmapConverter.serialize(bitmap, null, null);
		Bitmap newBitmap = bitmapConverter.deserialize(jsonElement, null, null);
		
		assertEquals(bitmap.getByteCount(), newBitmap.getByteCount());
		assertEquals(bitmap.getHeight(), newBitmap.getHeight());
		assertEquals(bitmap.getDensity(), newBitmap.getDensity());
		assertEquals(bitmap.getRowBytes(), newBitmap.getRowBytes());
	}

}
