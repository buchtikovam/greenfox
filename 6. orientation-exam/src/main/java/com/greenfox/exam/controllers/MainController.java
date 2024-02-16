package com.greenfox.exam.controllers;

import com.greenfox.exam.models.Item;
import com.greenfox.exam.services.ManufacturerService;
import com.greenfox.exam.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

	private final ItemService itemService;

	@Autowired
	public MainController(
		ItemService itemService
	) {
		this.itemService = itemService;
	}



	// show all clothes
	@GetMapping("/shopping-planner")
	public String index(Model model) {

		model.addAttribute(
			"unique_names",
			this.itemService.getUniqueItems(
				this.itemService.findAll()
			)
		);

		model.addAttribute(
			"items",
			this.itemService.findAll()
		);

		model.addAttribute(
			"sizes",
			this.itemService.getAllowedSizes()
		);

		return "index";
	}



	// show item summary based on form input

	// *note to a lovely mentor*
	// In this endpoint, it isn't really clear to me
	// what should the quantity do, so I implemented a counter instead
	// that works based on how many items of name and size were found in
	// the database. I hope it isn't too much of a problem

	@PostMapping("/shopping-planner/summary")
	public String showDetail(
		Model model,
		@RequestParam String item_name,
		@RequestParam String item_size,
		@RequestParam int quantity
	) {

		List<Item> matchedItems = this.itemService.getItemsByNameAndSize(item_name, item_size);

		if (matchedItems.isEmpty() || quantity < 0) {
			model.addAttribute(
				"reaction",
				"fail"
			);
			return "detail";
		}

		model.addAttribute(
			"reaction",
			"success"
		);

		model.addAttribute(
			"item",
			this.itemService.createTotalOfItem(matchedItems)
		);

		return "detail";
	}
}

