package com.clean.code.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clean.code.checkout.beans.Item;
import com.clean.code.checkout.beans.PricingRules;
import com.clean.code.checkout.enumeration.ItemCodeEnum;

/**
 * Checkout System.
 * 
 * @author rickblaze
 *
 */
public class CheckoutSystem {
	
	private List<Item> scannedItems = new ArrayList<>();
	
	private List<PricingRules> pricingRules = new ArrayList<>();
	
	/**
	 * Constructor
	 * @param pricingRules
	 */
	public CheckoutSystem(List<PricingRules> pricingRules){
		this.pricingRules = pricingRules;
	}

	/**
	 * Method to calculate the total price of items during checkout.
	 * 
	 * @param List<Item>
	 * @return int
	 */
	public int calculateTotalPrice() {
		int totalPrice = 0;
		
		Map<ItemCodeEnum, PricingRules> itemPriceRulesMap = new HashMap<>();
		for(PricingRules pricingRule : pricingRules){
			itemPriceRulesMap.put(pricingRule.getItemCode(), pricingRule);
		}
		
		for(Item item : scannedItems){
			PricingRules itemPricing = itemPriceRulesMap.get(item.getCode());
			totalPrice += itemPricing.getPrice(item.getQuantity());
		}		
		return totalPrice;
	}

	/**
	 * Method to scan the items.
	 * 
	 * @param Item ... varargs
	 * @return int - items scanned
	 */
	public int scan(Item ... items) {
		scannedItems.addAll(Arrays.asList(items));
		return items.length;
	}
}
