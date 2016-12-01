package com.clean.code.checkout;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CheckoutSystemShould {
	
	@Test
	public void return_50_for_one_unit_of_itemA_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		List<String> itemsAtCheckout = Arrays.asList("A");
		assertEquals(50, checkoutSystem.calculateTotalPrice(itemsAtCheckout));
	}
	
	@Test
	public void return_30_for_one_unit_of_itemB_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		List<String> itemsAtCheckout = Arrays.asList("B");
		assertEquals(30, checkoutSystem.calculateTotalPrice(itemsAtCheckout));
	}
	
	@Test
	public void return_80_for_one_unit_each_of_itemA_and_itemB_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		List<String> itemsAtCheckout = Arrays.asList("A", "B");
		assertEquals(80, checkoutSystem.calculateTotalPrice(itemsAtCheckout));
	}

}
