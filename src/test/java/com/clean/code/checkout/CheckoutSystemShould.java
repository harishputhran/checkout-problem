package com.clean.code.checkout;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.clean.code.checkout.beans.Item;


@RunWith(JUnit4.class)
public class CheckoutSystemShould {
	
	private Item itemA;
	private Item itemB;
	
	@Before
	public void setUp(){
		itemA = new Item("A", 50, true, 3, 130);		
		itemB = new Item("B", 30, true, 2, 45);
	}
	
	@After
	public void tearDown(){
		itemA = null;
		itemB = null;

	}
	
	@Test
	public void return_50_for_one_unit_of_itemA_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		List<Item> itemsAtCheckout = Arrays.asList(itemA);
		assertEquals(50, checkoutSystem.calculateTotalPrice(itemsAtCheckout));
	}
	
	@Test
	public void return_30_for_one_unit_of_itemB_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		List<Item> itemsAtCheckout = Arrays.asList(itemB);
		assertEquals(30, checkoutSystem.calculateTotalPrice(itemsAtCheckout));
	}
	
	@Test
	public void return_80_for_one_unit_each_of_itemA_and_itemB_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		List<Item> itemsAtCheckout = Arrays.asList(itemA, itemB);
		assertEquals(80, checkoutSystem.calculateTotalPrice(itemsAtCheckout));
	}
	
	@Test
	public void return_discounted_price_of_130_for_three_units_of_itemA_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		List<Item> itemsAtCheckout = Arrays.asList(itemA, itemA, itemA);
		assertEquals(130, checkoutSystem.calculateTotalPrice(itemsAtCheckout));
	}
}
