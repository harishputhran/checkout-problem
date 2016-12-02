package com.clean.code.checkout;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.clean.code.checkout.beans.Discount;
import com.clean.code.checkout.beans.Item;
import com.clean.code.checkout.beans.PricingRules;
import com.clean.code.checkout.enumeration.ItemCodeEnum;


@RunWith(JUnit4.class)
public class CheckoutSystemShould {
	
	private Item itemA;
	private Item itemB;
	private Item itemC;
	private List<PricingRules> pricingRules;
	
	@Before
	public void setUp(){
		Discount discountForItemA = new Discount(3, 130);
		Discount discountForItemB = new Discount(2, 45);
		
		PricingRules pricingForItemA = new PricingRules(ItemCodeEnum.A, 50, discountForItemA);
		PricingRules pricingForItemB = new PricingRules(ItemCodeEnum.B, 30, discountForItemB);
		pricingRules = new ArrayList<>();
		pricingRules.add(pricingForItemA);
		pricingRules.add(pricingForItemB);
		
		itemA = new Item(ItemCodeEnum.A);		
		itemB = new Item(ItemCodeEnum.B);
		itemC = new Item(ItemCodeEnum.C);
	}
	
	@After
	public void tearDown(){
		itemA = null;
		itemB = null;
		itemC = null;
		pricingRules = null;
	}
	
	@Test
	public void return_50_for_one_unit_of_itemA_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		checkoutSystem.scan(itemA);
		assertEquals(50, checkoutSystem.calculateTotalPrice());
	}
	
	@Test
	public void return_30_for_one_unit_of_itemB_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		checkoutSystem.scan(itemB);
		assertEquals(30, checkoutSystem.calculateTotalPrice());
	}
	
	@Test
	public void return_80_for_one_unit_each_of_itemA_and_itemB_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		checkoutSystem.scan(itemA, itemB);
		assertEquals(80, checkoutSystem.calculateTotalPrice());
	}
	
	@Test
	public void return_discounted_price_of_130_for_three_units_of_itemA_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		checkoutSystem.scan(itemA, itemA, itemA);
		assertEquals(130, checkoutSystem.calculateTotalPrice());
	}
	
	@Test
	public void return_price_of_260_for_six_units_of_itemA_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		checkoutSystem.scan(itemA, itemA, itemA, itemA, itemA, itemA);
		assertEquals(260, checkoutSystem.calculateTotalPrice());
	}
	
	@Test
	public void return_price_of_210_for_four_units_of_itemA_and_one_unit_of_itemB_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		checkoutSystem.scan(itemA, itemA, itemA, itemA, itemB);
		assertEquals(210, checkoutSystem.calculateTotalPrice());
	}
	
	@Test
	public void return_price_of_215_for_3_units_of_itemA_two_units_of_itemB_and_two_units_of_itemC_in_random_order_at_checkout(){
		PricingRules pricingForItemC = new PricingRules(ItemCodeEnum.C, 20, null);
		pricingRules.add(pricingForItemC);
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		checkoutSystem.scan(itemC, itemA, itemB, itemA, itemC, itemA, itemB);
		assertEquals(215, checkoutSystem.calculateTotalPrice());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void throw_illegala_argument_exception_when_there_is_no_pricing_for_itemC_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		checkoutSystem.scan(itemC, itemA, itemB, itemA, itemC, itemA, itemB);
		checkoutSystem.calculateTotalPrice();
	}
	
	@Test
	public void return_true_when_one_item_is_scanned_at_a_time_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		assertEquals(1, checkoutSystem.scan(itemA));	
	}
	
	@Test
	public void return_true_when_two_items_are_scanned_at_a_time_at_checkout(){
		CheckoutSystem checkoutSystem = new CheckoutSystem(pricingRules);
		assertEquals(2, checkoutSystem.scan(itemA, itemB));
	}
}
