package com.clean.code.checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSystem {

	public int calculateTotalPrice(String itemAtCheckout) {
		Map<String, Integer> itemPriceMap = new HashMap<>(2);
		itemPriceMap.put("A", 50);
		itemPriceMap.put("B", 30);
		return itemPriceMap.getOrDefault(itemAtCheckout, 0);
	}

}
