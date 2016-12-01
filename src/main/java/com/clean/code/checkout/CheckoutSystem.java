package com.clean.code.checkout;

public class CheckoutSystem {

	public int calculateTotalPrice(String itemAtCheckout) {
		if ("A".equals(itemAtCheckout)) {			
			return 50;
		}
		if("B".equals(itemAtCheckout)){
			return 30;
		}
		return 0;
	}

}
