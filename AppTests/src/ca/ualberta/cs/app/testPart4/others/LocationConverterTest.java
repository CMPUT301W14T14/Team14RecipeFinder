/**
 * 
 */
package ca.ualberta.cs.app.testPart4.others;

import com.google.gson.JsonElement;
import customlized_gson.LocationConverter;
import activity.AllTopicPageActivity;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for LocationConverter.
 * 
 * @author Yilu Su
 *
 */
public class LocationConverterTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	public LocationConverterTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether the LocationConverter can properly serialize and deserialize a location <br>
	 * First, create a mockup location. Serialize followed by deserialize, and then check. <br>
	 * Methods tested: serialize and deserialize.
	 */
	public void testLocationConverter() {
		Location location = new Location("mock");
		location.setAccuracy(10);
		location.setAltitude(20);
		location.setLatitude(30);
		location.setLongitude(40);
		LocationConverter locationConverter = new LocationConverter();
		JsonElement jsonElement = locationConverter.serialize(location, null, null);
		Location newLocation = locationConverter.deserialize(jsonElement, null, null);
		
		assertEquals(location.getProvider(), newLocation.getProvider());
		assertEquals(location.getAccuracy(), newLocation.getAccuracy());
		assertEquals(location.getAltitude(), newLocation.getAltitude());
		assertEquals(location.getLatitude(), newLocation.getLatitude());
		assertEquals(location.getLongitude(), newLocation.getLongitude());
	}

}
