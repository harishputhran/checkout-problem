package com.clean.code.checkout;

import java.util.List;

import com.clean.code.checkout.beans.Item;

public class CheckoutSystem {

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
		if(item.getQuantity() % item.getDiscountEligibleQuantity() == 0){
			int totalPrice = price - item.getQuantity() * item.getPrice();
			totalPrice += item.getDiscountPrice();
			/*
			 * Reset Quantity to ensure that after each discount quantity grouping,
			 * quantity is reset to look for next discount quantity grouping.
			*/
			item.resetQuantity();
			return totalPrice;
		}
		return price;
	}

}
