package de.aron.androidjunit.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import de.ronneby.shopsystem.MainActivity;

/**
 * @author Shopgate 
 * -> Aron
 * Run as Android JUnit Test
 * for this you need a device or an emulator 
 */
public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

	MainActivity main;

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
		startActivity(intent, null, null);
		main = getActivity();
	}
	
	public void testClass() throws Exception {
		assertNotNull(main);
	}
	
	public void testAppName() throws Exception {
		String appName = main.getString(de.ronneby.creditcardscan.R.string.app_name);
		assertNotNull(appName);
		assertEquals("Shopsystem", appName);
	}
}
