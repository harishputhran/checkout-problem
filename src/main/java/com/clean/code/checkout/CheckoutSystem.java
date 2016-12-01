package com.clean.code.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clean.code.checkout.beans.Item;
import com.clean.code.checkout.beans.PricingRules;
import com.clean.code.checkout.enumeration.ItemCodeEnum;

public class CheckoutSystem {
	
	private List<Item> scannedItems = new ArrayList<>();
	
	private List<PricingRules> pricingRules = new ArrayList<>();
	
	public CheckoutSystem(List<PricingRules> pricingRules){
		this.pricingRules = pricingRules;
	}

	public int calculateTotalPrice(List<Item> itemsAtCheckout) {
		int totalPrice = 0;
		
		Map<ItemCodeEnum, PricingRules> itemPriceRulesMap = new HashMap<>();
		for(PricingRules pricingRule : pricingRules){
			itemPriceRulesMap.put(pricingRule.getItemCode(), pricingRule);
		}
		
		for(Item item : itemsAtCheckout){
			item.increaseQuantity();
			PricingRules itemPricing = itemPriceRulesMap.get(item.getCode());			
			if(itemPricing != null){
				totalPrice += itemPricing.getActualPrice();
			}else{
				throw new IllegalArgumentException("Item does not have a valid Pricing");
			}
		}
		return totalPrice;
	}

	public boolean scan(Item ... items) {
		return scannedItems.addAll(Arrays.asList(items));
	}
}
