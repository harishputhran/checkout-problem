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
		int discountPriceForItemA = 130;
		int dicountApplicableItemAQuantity = 3;
		int countOfItemA = 0;
		for(String item : itemsAtCheckout){
			if("A".equals(item)){
				countOfItemA++;
			}
			totalPrice += itemPriceMap.get(item);
			
			if(countOfItemA == dicountApplicableItemAQuantity){
				totalPrice -= countOfItemA * itemPriceMap.get("A");
				totalPrice += discountPriceForItemA;
				countOfItemA = 0;
			}
		}
		return totalPrice;
	}

}
