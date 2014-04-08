/**
 * 
 */
package ca.ualberta.cs.app.testPart4.activity;

import activity.FavoritePageActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * JUnit test cases for FavoritePageActivity.
 * 
 * @author Yilu Su
 *
 */
public class FavoritePageActivityTest extends
		ActivityInstrumentationTestCase2<FavoritePageActivity> {
	

	FavoritePageActivity mActivity;
	Spinner mSpinner;
	ListView mListView;
	
	/**
	 * Constructor 
	 */
	public FavoritePageActivityTest() {
		super(FavoritePageActivity.class);
	}
	
	/**
     * Sets up the test environment before each test.
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
	@Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        mActivity = getActivity();
        mSpinner = (Spinner) mActivity.findViewById(com.example.projectapp.R.id.fav_spinner);
        mListView = (ListView) mActivity.findViewById(com.example.projectapp.R.id.favorite_list);
    }
	
	/**
	 * Verify Spinner Layout Parameters
	 */
	@MediumTest
	public void testSpinnerLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mSpinner);

	    final ViewGroup.LayoutParams layoutParams = mSpinner.getLayoutParams();
	    assertNotNull(layoutParams);
	    assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * Verify ListView Layout Parameters
	 */
	@MediumTest
	public void testListViewLayout() {
	    final View decorView = mActivity.getWindow().getDecorView();
	    ViewAsserts.assertOnScreen(decorView, mListView);
	    
	    final ViewGroup.LayoutParams layoutParams = mListView.getLayoutParams();
	    assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
}
