package com.clean.code.checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSystem {

	public int calculateTotalPrice(List<String> itemsAtCheckout) {
		Map<String, Integer> itemPriceMap = new HashMap<>(2);
		int totalPrice = 0;
		itemPriceMap.put("A", 50);
		itemPriceMap.put("B", 30);
		for(String item : itemsAtCheckout){
			totalPrice += itemPriceMap.get(item);
		}
		return totalPrice;
	}

}
