package de.aron.junit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import org.junit.Test;
import de.ronneby.barcodescanner.Product;
import de.ronneby.creditcardscan.MyCreditCard;

/**
 *  @author Shopgate
 *  -> Aron
 *  Run as JUnit Test
 */
public class ProductTest {
	
	Product product  = new Product();
	Product product2 = new Product("TV", 1399.00, "24101995");
	MyCreditCard cc = new MyCreditCard("4111111111111", 12, 19, "123", "5566");
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<MyCreditCard> cards = new ArrayList<MyCreditCard>();
	long id = 6;
	
	@Test
	public void testProductConstructor() throws Exception{
		assertNotNull(product);
		assertEquals("Nothing", product.getName());
		assertEquals("00000000", product.getCode());
		
		assertNotNull(product2);
		assertEquals("TV", product2.getName());
		assertEquals("24101995", product2.getCode());
		
		Product p = new Product();
		p.setName("Tasse");
		p.setPrice(6.88);
		p.setCode("55446677");
		p.setId(id);
		
		assertNotNull(p);
		assertEquals((long)6, p.getId());
		assertEquals("Tasse", p.getName());
		assertEquals("55446677", p.getCode());
	}
	
	@Test
	public void testCreditCardConstructor() throws Exception{
		
		cc.setId(id);
		
		assertNotNull(cc);
		assertEquals((long) 6, cc.getId());
		assertEquals("4111111111111", cc.cardNumber);
		assertEquals(12, cc.expiryMonth);
		assertEquals(19, cc.expiryYear);
		assertEquals("123", cc.cvv);
		assertEquals("5566", cc.postalCode);
	}
	
	@Test
	public void testList() throws Exception{
		int index = 0;
		
		for(int i = 0; i < 5; i++){
			products.add(product);
			cards.add(cc);
		}
		
		assertEquals(5, products.size());	
		assertEquals(5, products.size());
		
		products.remove(index);
		cards.remove(index);
		
		assertEquals(4, products.size());
		assertEquals(4, products.size());
	}
	
	@Test
	public void testTotalAmount() throws Exception{
		double sum = 0.0;
		createList(5);
		
		for(int k  = 0; k < products.size(); k++){
			sum += product.getPrice();
		}
		if(500.0 == sum){
			//death code
		}
		
	}
	
	
    //////////////////////////////////////////////////\NO TEST METHODS/////////////////////////////////////////////////////////////////////
	public void createList(int size){
		for(int i = 0; i < size; i++){
			products.add(product);
		}
	}
}