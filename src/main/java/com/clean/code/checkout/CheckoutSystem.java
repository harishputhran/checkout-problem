package com.clean.code.checkout;

import java.util.ArrayList;
import java.util.List;

import com.clean.code.checkout.beans.Item;

public class CheckoutSystem {
	
	private List<Item> scannedItems = new ArrayList<>();

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

	public boolean scan(Item itemA) {
		return scannedItems.add(itemA);
	}
}
