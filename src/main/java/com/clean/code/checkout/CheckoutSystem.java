package com.clean.code.checkout;

import java.util.List;

import com.clean.code.checkout.beans.Item;

public class CheckoutSystem {

	public int calculateTotalPrice(List<Item> itemsAtCheckout) {
		int totalPrice = 0;

		for(Item item : itemsAtCheckout){
			item.increaseQuantity();
			totalPrice += item.getPrice();	
			
			if(item.hasDiscount() && 
					item.getQuantity() % item.getDiscountEligibleQuantity() == 0){
				totalPrice -= item.getQuantity() * item.getPrice();
				totalPrice += item.getDiscountPrice();
				/*
				 * Reset Quantity to ensure that after each discount quantity grouping,
				 * quantity is reset to look for next discount quantity grouping.
				*/
				item.resetQuantity();
			}
		}
		return totalPrice;
	}

}
