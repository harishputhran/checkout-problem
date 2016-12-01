package com.clean.code.checkout.beans;

import com.clean.code.checkout.enumeration.ItemCodeEnum;

public class Item {
	
	private ItemCodeEnum code;
	
	private int price;
	
    private Discount discount; 
	
	private int quantity;
	
	public Item(ItemCodeEnum code, int price, Discount discount){
		this.code = code;
		this.price = price;
		this.discount = discount;
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
	public ItemCodeEnum getCode() {
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
	
	public Discount getDiscount() {
		return discount;
	}
	
	public boolean hasDiscount(){
		return this.discount != null;
	}
}
