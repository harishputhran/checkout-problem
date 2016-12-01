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
				
				if(!itemPricing.hasDiscount()){
					continue;
				}
				if(item.getQuantity() % itemPricing.getDiscount().getQuantity() == 0){
					
					totalPrice = deductItemPriceFromTotalCalculatedPrice(totalPrice, item.getQuantity(), itemPricing);
					
					totalPrice = addItemDiscountedPriceToTotalPrice(totalPrice, itemPricing);
					/*
					 * Reset Quantity to ensure that after each discount quantity grouping,
					 * quantity is reset to look for next discount quantity grouping.
					*/
					item.resetQuantity();
				}
			}else{
				throw new IllegalArgumentException("Item does not have a valid Pricing");
			}
		}
		return totalPrice;
	}

	
	/**
	 * Method to deduct the Item Price from total price in the case of discount.
	 * 
	 * @param int
	 * @param Item
	 * @param itemPricing
	 * @return int
	 */
	private int deductItemPriceFromTotalCalculatedPrice(int totalPrice, int quantity, PricingRules itemPricing) {
		return totalPrice - quantity * itemPricing.getActualPrice();
	}
	
	/**
	 * Method to add the Discounted price for the item to total price.
	 * 
	 * @param int
	 * @param PricingRules
	 * @return int
	 */
	private int addItemDiscountedPriceToTotalPrice(int calculatedPrice, PricingRules itemPricing) {
		return calculatedPrice + itemPricing.getDiscount().getPrice();
	}

	/**
	 * Method to scan the items.
	 * 
	 * @param Item ... varargs
	 * @return boolean
	 */
	public boolean scan(Item ... items) {
		return scannedItems.addAll(Arrays.asList(items));
	}
}
