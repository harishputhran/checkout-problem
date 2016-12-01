package com.clean.code.checkout;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CheckoutSystemShould {
	
	@Test
	public void return_50_for_one_unit_of_itemA_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		assertEquals(50, checkoutSystem.calculateTotalPrice("A"));
	}

}
