package de.aron.androidjunit.test;

import de.ronneby.barcodescanner.AddProductActivity;
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
public class AddProduktActivityTest extends ActivityUnitTestCase<AddProductActivity>{

	AddProductActivity add;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), AddProductActivity.class);
		startActivity(intent, null, null);
		add = getActivity();
	}
	
	public AddProduktActivityTest() {
		super(AddProductActivity.class);
	}
	
	public void testClass() throws Exception {
		assertNotNull(add);
	}
	
	public void testAddProduct() throws Exception {
		EditText etName  = (EditText) add.findViewById(de.ronneby.creditcardscan.R.id.editText_product_anme);
		EditText etPrice = (EditText) add.findViewById(de.ronneby.creditcardscan.R.id.editText_product_price);
		Button btnScan   = (Button) add.findViewById(de.ronneby.creditcardscan.R.id.button_scan_product_barcode);
		
		assertNotNull(etName);
		assertNotNull(etPrice);
		assertNotNull(btnScan);
		
		etName.setText("Monitor");
		etPrice.setText("399.99");
		btnScan.performClick();		
	}
}
