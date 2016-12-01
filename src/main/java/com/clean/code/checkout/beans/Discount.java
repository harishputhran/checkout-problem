package com.clean.code.checkout.beans;

public class Discount {
	
	private int quantity;
	private int price;
	
	public Discount(int quantity, int price){
		this.quantity = quantity;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}
}
