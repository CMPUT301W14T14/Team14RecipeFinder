
/**
 * 
 */
package ca.ualberta.cs.app.testPart4.handler;

import network_io.ConnectionChecker;
import activity.AllTopicPageActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * JUnit test cases for ConnectionChecker.
 * 
 * @author Yilu Su
 *
 */
public class ConnectionCheckerTest extends
		ActivityInstrumentationTestCase2<AllTopicPageActivity> {

	/**
	 * Constructor
	 */
	public ConnectionCheckerTest() {
		super(AllTopicPageActivity.class);
	}

	/**
	 * Test whether the network connection is detectable. By default, the connection is enabled.
	 * @throws Exception
	 */
	public void testIsNetworkOnline() throws Exception {
//		setMobileDataEnabled(this.getInstrumentation().getTargetContext(), false);

//		WifiManager wifiManager = (WifiManager)this.getInstrumentation().getTargetContext().getSystemService(Context.WIFI_SERVICE);
//		wifiManager.setWifiEnabled(false);

		ConnectionChecker connectionChecker = new ConnectionChecker();
		assertTrue(connectionChecker.isNetworkOnline(getActivity()));
	}

//	private void setMobileDataEnabled(Context context, boolean enabled)
//			throws Exception {
//		final ConnectivityManager conman = (ConnectivityManager) context
//				.getSystemService(Context.CONNECTIVITY_SERVICE);
//		@SuppressWarnings("rawtypes")
//		final Class conmanClass = Class.forName(conman.getClass().getName());
//		final Field iConnectivityManagerField = conmanClass
//				.getDeclaredField("mService");
//		iConnectivityManagerField.setAccessible(true);
//		final Object iConnectivityManager = iConnectivityManagerField
//				.get(conman);
//		@SuppressWarnings("rawtypes")
//		final Class iConnectivityManagerClass = Class
//				.forName(iConnectivityManager.getClass().getName());
//		@SuppressWarnings("unchecked")
//		final Method setMobileDataEnabledMethod = iConnectivityManagerClass
//				.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
//		setMobileDataEnabledMethod.setAccessible(true);
//		setMobileDataEnabledMethod.invoke(iConnectivityManager, enabled);
//	}

}
