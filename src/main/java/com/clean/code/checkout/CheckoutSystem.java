package com.clean.code.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clean.code.checkout.beans.Item;
import com.clean.code.checkout.beans.PricingRules;

public class CheckoutSystem {
	
	private List<Item> scannedItems = new ArrayList<>();
	
	private List<PricingRules> pricingRules = new ArrayList<>();
	
	public CheckoutSystem(){
	}

	public int calculateTotalPrice(List<Item> itemsAtCheckout) {
		int totalPrice = 0;
		for(Item item : itemsAtCheckout){
			item.increaseQuantity();
			totalPrice += item.getPrice();			
			totalPrice = applyDiscount(totalPrice, item);
		}
		return totalPrice;
	}

	private int applyDiscount(int price, Item item) {
		if(!item.hasDiscount()){
			return price;
		}
		
		if(item.getQuantity() % item.getDiscount().getQuantity() == 0){
			int totalPrice = price - item.getQuantity() * item.getPrice();
			totalPrice += item.getDiscount().getPrice();
			/*
			 * Reset Quantity to ensure that after each discount quantity grouping,
			 * quantity is reset to look for next discount quantity grouping.
			*/
			item.resetQuantity();
			return totalPrice;
		}
		return price;
	}

	public boolean scan(Item ... items) {
		return scannedItems.addAll(Arrays.asList(items));
	}
}
