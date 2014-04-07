/**
 * 
 */
package ca.ualberta.cs.app.testPart4.model;

import model.IdSet;

import activity.AllTopicPageActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for IdSet model.
 * 
 * @author Yilu Su
 *
 */
public class IdSetModelTest extends ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor 
	 */
	public IdSetModelTest() {
		super(AllTopicPageActivity.class);
	}

	/**
     * Test cases for IdSet model. <br>
     * Create a idSet and some strings.
     * First, add strings to the idSet and check the content. 
     * Then, clear the idSet and check the content again.
     */
	public void testIdSetModel() {
		String string1 = "id 1";
		String string2 = "id 2";
		IdSet idSet = new IdSet();
		idSet.add(string1);
		idSet.add(string2);
		assertEquals("id 1", idSet.getSet().get(0));
		assertEquals("id 2", idSet.getSet().get(1));
		
		idSet.clear();
		assertEquals(true, idSet.getSet().isEmpty());
	}

}
