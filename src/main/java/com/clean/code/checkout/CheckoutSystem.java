package com.clean.code.checkout;

public class CheckoutSystem {

	public int calculateTotalPrice(String itemAtCheckout) {
		if ("A".equals(itemAtCheckout)) {			
			return 50;
		}
		return 0;
	}

}
