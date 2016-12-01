package com.clean.code.checkout.beans;

public class Item {
	
	private String code;
	
	private int price;
	
	private boolean hasDiscount;
	
	private int discountEligibleQuantity;
	
	private int discountPrice;
	
	private int quantity;
	
	public Item(String code, int price,
				boolean hasDiscount, int discountEligibleQuantity,
				int discountPrice){
		this.code = code;
		this.price = price;
		this.hasDiscount = hasDiscount;
		this.discountEligibleQuantity = discountEligibleQuantity;
		this.discountPrice = discountPrice;
	}

	/**
	 * Equals method.
	 */
	@Override
	public boolean equals(Object objectToCompare){
		if(this == objectToCompare){
			return true;
		}
		if(objectToCompare == null || objectToCompare.getClass() != this.getClass()){
			return false;
		}
		Item item = (Item) objectToCompare;
		return (code != null && code.equals(item.getCode()));
	}
	
	/**
	 * Hashcode method.
	 */
	@Override
	public int hashCode(){
		return code.hashCode() * (22/7);
	}

	//Getters
	public String getCode() {
		return code;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void resetQuantity() {
		quantity = 0;
	}
	
	public void increaseQuantity(){
		this.quantity++;
	}

	
	public int getDiscountEligibleQuantity() {
		return discountEligibleQuantity;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public boolean hasDiscount() {
		return hasDiscount;
	}
}
