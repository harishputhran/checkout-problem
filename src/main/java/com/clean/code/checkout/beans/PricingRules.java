package com.clean.code.checkout.beans;

import com.clean.code.checkout.enumeration.ItemCodeEnum;

/**
 * Pricing Rules.
 * 
 * @author rickblaze
 *
 */
public class PricingRules {
	
	private ItemCodeEnum itemCode;
	
	private int actualPrice;
	
	private Discount discount;
	
	public PricingRules(ItemCodeEnum itemCode, int actualPrice, Discount discount){
		this.itemCode = itemCode;
		this.actualPrice = actualPrice;
		this.discount = discount;
	}

	// Getters.
	public ItemCodeEnum getItemCode() {
		return itemCode;
	}
	
	public int getPrice(int quantity){
		
		if(this.discount != null && quantity >= discount.getQuantity()){
			int countOfRemainingQuantity = quantity % discount.getQuantity();			
			int countOfDiscountableQuantity = quantity / discount.getQuantity();
			
			return countOfDiscountableQuantity * discount.getPrice() + countOfRemainingQuantity * actualPrice;
		}
		return quantity * actualPrice;
	}
	
}
