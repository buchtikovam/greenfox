package com.greenfoxacademy.basicwebshop.actions;

import com.greenfoxacademy.basicwebshop.models.ShopItem;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainActions {
	// Helper method to get only available items
	public List<ShopItem> getAvailableItems(List<ShopItem> items) {
		return items.stream()
			.filter(item -> item.getQuantityOfStock() > 0)
			.collect(Collectors.toList());
	}

	// Helper method to sort items by price
	public List<ShopItem> getItemsFromCheapest(List<ShopItem> items) {
		return items.stream()
			.sorted(Comparator.comparing(ShopItem::getPrice))
			.collect(Collectors.toList());
	}
}
