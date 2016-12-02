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
	public int getActualPrice() {
		return actualPrice;
	}

	public Discount getDiscount() {
		return discount;
	}

	public ItemCodeEnum getItemCode() {
		return itemCode;
	}
	
	public boolean hasDiscount(){
		return this.discount != null;
	}
	
	
	public int getPrice(int quantity){
		int countOfDiscountableQuantity = quantity % discount.getQuantity();
		int countOfRemainingQuantity = quantity / discount.getQuantity();
		return countOfDiscountableQuantity * discount.getPrice() + countOfRemainingQuantity * actualPrice;
	}
	
}
