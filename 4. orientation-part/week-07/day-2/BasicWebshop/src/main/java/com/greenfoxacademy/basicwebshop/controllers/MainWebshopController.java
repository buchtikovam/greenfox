package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MainWebshopController {

	List<ShopItem> items = new ArrayList<>(Arrays.asList(
		new ShopItem(
			"Apple",
			"Delicious fruit from our local farmer.",
			"Fruit",
			5,
			26
		),

		new ShopItem(
			"Tangerine",
			"Yummy fruit from China.",
			"Fruit",
			4,
			31
		),

		new ShopItem(
			"Cactus",
			"Lovely decoration for every home.",
			"Plant",
			50,
			5
		),

		new ShopItem(
			"Kettle",
			"Buy a kettle to warm you up on cold days.",
			"Kitchenware",
			300,
			0
		),

		new ShopItem(
			"Lollipop",
			"A sweet treat you deserve regardless of your age.",
			"Sweets",
			2,
			10
		)
	));


	// List all shop items
	@RequestMapping(
		value = "/",
		method = RequestMethod.GET
	)
	public String index(Model model) {
		model.addAttribute("items", this.items);
		return "index";
	}



	// List only available items
	@RequestMapping(
		value = "/only-available",
		method = RequestMethod.GET
	)
	public String filterAvailable(Model model) {
		model.addAttribute(
			"items",
			getAvailableItems(this.items)
		);
		return "index";
	}



	// Sort items by price from cheapest
	@RequestMapping(
		value = "/cheapest-first",
		method = RequestMethod.GET
	)
	public String orderItemsASC(Model model) {
		model.addAttribute(
			"items",
			getItemsFromCheapest(this.items)
		);
		return "index";
	}

	// Find items containing specified string
	@RequestMapping(
		value = "/contains-fruit",
		method = RequestMethod.GET
	)
	public String findSpecifiedItems(Model model) {
		model.addAttribute(
			"items",
			getItemsBySpecifiedString(this.items, "fruit")
		);
		return "index";
	}



	// Get average of stock
	@RequestMapping(
		value = "/average-stock",
		method = RequestMethod.GET
	)
	public String showStockAverage(Model model) {
		model.addAttribute(
			"fill",
			getStockAverage(this.items)
		);
		return "detail";
	}



	// Return most expensive item in stock
	@RequestMapping(
		value = "/most-expensive",
		method = RequestMethod.GET
	)
	public String showMostExpensiveAvailable(Model model) {
		model.addAttribute("fill", getMostExpensive(this.items));
		return "detail";
	}



	// Search bar
	@RequestMapping(
		value = "/search",
		method = RequestMethod.POST
	)
	public String search(@RequestParam String search, Model model) {
		model.addAttribute(
			"items",
			getItemsBySpecifiedString(this.items, search)
		);
		return "index";
	}



	// HELPER METHODS



	// Get only available items
	public List<ShopItem> getAvailableItems(List<ShopItem> items) {
		return items.stream()
			.filter(item -> item.getQuantityOfStock() > 0)
			.collect(Collectors.toList());
	}

	// Sort items by price
	public List<ShopItem> getItemsFromCheapest(List<ShopItem> items) {
		return items.stream()
			.sorted(Comparator.comparing(ShopItem::getPrice))
			.collect(Collectors.toList());
	}

	// Filter items by string
	public List<ShopItem> getItemsBySpecifiedString(List<ShopItem> items, String condition) {
		return items.stream()
			.filter(
				item ->
					item.getDescription().toLowerCase()
						.contains(condition.toLowerCase()) ||
					item.getName().toLowerCase()
						.contains(condition.toLowerCase())
				)
			.collect(Collectors.toList());
	}

	// Return average of current stock
	public String getStockAverage(List<ShopItem> list) {
		return
			"Average stock: "
				+ items.stream().
					mapToDouble(ShopItem::getQuantityOfStock)
					.average()
					.orElse(0.0)
		;
	}

	// Return most expensive item in stock
	public String getMostExpensive(List<ShopItem> list) {
		List<ShopItem> availableItems = getAvailableItems(list);
		Optional<ShopItem> mostExpensive = availableItems.stream()
			.max(Comparator.comparing(ShopItem::getPrice));

		return mostExpensive.map(
			shopItem -> "The most expensive available item is: "
				+ shopItem.getName()).orElse("No items found"
		);
	}

	// Filter items by type
	public List<ShopItem> getItemsByType(List<ShopItem> items, String condition) {
		return items.stream()
			.filter(item -> item.getType().equalsIgnoreCase(condition))
			.collect(Collectors.toList());
	}
}
