package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.IceCreamComponents;
import model.Ingredients;

/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Jan 26, 2022
 */
public class TestLogic {
	Ingredients order = new Ingredients();
	IceCreamComponents customer1 = new IceCreamComponents("cup", 1, "vanilla", true);
	IceCreamComponents customer2 = new IceCreamComponents("cone", 2, "chocolate", false);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void priceCalculator() {
		double customerOrder = order.priceCalculator();
		assertEquals(.50, .50, customerOrder);
	}

	@Test
	public void testHasFixins() {
		customer1.setTopping(true);
		assertTrue(order.allTheFixins(customer1));
	}
	
	@Test 
	public void testNoFixins() {
		customer2.setTopping(true);
		assertFalse(order.allTheFixins(customer2));
	}
}
