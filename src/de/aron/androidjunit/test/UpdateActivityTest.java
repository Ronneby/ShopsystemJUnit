package de.aron.androidjunit.test;

import de.ronneby.creditcardscan.UpdateActivity;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Shopgate 
 * -> Aron
 * Run as Android JUnit Test
 * for this you need a device or an emulator 
 */
public class UpdateActivityTest extends ActivityUnitTestCase<UpdateActivity> {

	private UpdateActivity up;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), UpdateActivity.class);
		startActivity(intent, null, null);
		up = getActivity();
	}

	public UpdateActivityTest() {
		super(UpdateActivity.class);
	}
	
	public void testClass() throws Exception {
		assertNotNull(up);
	}
	
	public void testUpdate() throws Exception {
		
		EditText editNumber = (EditText) up.findViewById(de.ronneby.creditcardscan.R.id.number);
		EditText editDate   = (EditText) up.findViewById(de.ronneby.creditcardscan.R.id.date);
		Button btnSave      = (Button) up.findViewById(de.ronneby.creditcardscan.R.id.save);
		
		assertNotNull(editNumber);
		assertNotNull(editDate);
		assertNotNull(btnSave);
		
		editNumber.setText("");
		editDate.setText("11/17");
		btnSave.performClick();		
	}
}
