package com.greenfox.exam.controllers;

import com.greenfox.exam.DTOs.ItemDTO;
import com.greenfox.exam.DTOs.ItemWithoutIdDTO;
import com.greenfox.exam.models.Item;
import com.greenfox.exam.services.ItemService;
import com.greenfox.exam.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MainRestController {

	private final ManufacturerService manufacturerService;
	private final ItemService itemService;

	@Autowired
	public MainRestController(ManufacturerService manufacturerService, ItemService itemService) {
		this.manufacturerService = manufacturerService;
		this.itemService = itemService;
	}


	// show JSON of items, based on input in url
	@GetMapping("/item")
	public ResponseEntity showItems(
		@RequestParam(required = false) String manufacturer,
		@RequestParam(required = false) String size
	) {
		List<Item> allItems = this.itemService.findAll();
		List<ItemDTO> allItemsDTO = new ArrayList<>();
		Map<String, List<ItemDTO>> response = new HashMap<>();

		// if no parameter were given
		if (manufacturer == null && size == null) {

			for (Item item : allItems) {
				allItemsDTO.add(new ItemDTO(item));
			}

			response.put("clothes", allItemsDTO);
			return ResponseEntity.status(200).body(response);
		}


		// if only manufacturer was given
		if (size == null) {
			List<Item> itemsByManufacturer = this.itemService.getItemsByManufacturer(
				allItems,
				manufacturer
			);

			for (Item item : itemsByManufacturer) {
				allItemsDTO.add(new ItemDTO(item));
			}

			response.put("clothes", allItemsDTO);
			return ResponseEntity.status(200).body(response);
		}


		// if only size was given
		if (manufacturer == null) {
			List<Item> itemsBySize = this.itemService.getItemsBySize(allItems, size);

			for (Item item : itemsBySize) {
				allItemsDTO.add(new ItemDTO(item));
			}

			response.put("clothes", allItemsDTO);
			return ResponseEntity.status(200).body(response);
		}


		// if both parameters were given
		List<Item> itemsBySizeAndManufacturer =
			this.itemService.getItemsBySizeAndManufacturer(
				allItems,
				size,
				manufacturer
			);

		for (Item item : itemsBySizeAndManufacturer) {
			allItemsDTO.add(new ItemDTO(item));
		}

		response.put("clothes", allItemsDTO);
		return ResponseEntity.status(200).body(response);
	}



	// delete item by id
	@DeleteMapping("/item/{id}")
	public ResponseEntity<Map<String, String>> destroyItem(
		@PathVariable Long id
	) {

		Optional<Item> itemOptional = this.itemService.findById(id);
		Map<String, String> response = new HashMap<>();

		if (itemOptional.isPresent()) {
			Item item = itemOptional.get();
			this.itemService.delete(item);
			return ResponseEntity.status(204).build();
		}

		response.put("error-message", "Incorrect provided data");
		return ResponseEntity.status(404).body(response);
	}



	// update item based on id and body
	@PutMapping("/item/{id}")
	public ResponseEntity updateItem(
		@RequestBody ItemWithoutIdDTO itemWithoutIdDTO,
		@PathVariable Long id
	) {
		Optional<Item> itemOptional = this.itemService.findById(id);
		Map<String, String> response = new HashMap<>();


		if (itemOptional.isPresent()) {
			// checking if correct data was sent in DTO
			if (this.itemService.getAllowedCategories().contains(itemWithoutIdDTO.getCategory()) &&
				this.itemService.getAllowedSizes().contains(itemWithoutIdDTO.getSize()) &&
				itemWithoutIdDTO.getUnit_price() >= 0 &&
				this.manufacturerService.existsByName(itemWithoutIdDTO.getManufacturer())
			) {
				// if all validations passed
				Item foundItem = itemOptional.get();

				foundItem.setName(itemWithoutIdDTO.getName());
				foundItem.setManufacturer(
					this.manufacturerService.findByName(
						itemWithoutIdDTO.getManufacturer()
					).get()
				);
				foundItem.setCategory(itemWithoutIdDTO.getCategory());
				foundItem.setSize(itemWithoutIdDTO.getSize());
				foundItem.setUnit_price(itemWithoutIdDTO.getUnit_price());

				this.itemService.save(foundItem);
				return ResponseEntity.status(200).body(new ItemDTO(foundItem));
			}

			// if validations didn't pass
			return ResponseEntity.status(400).build();
		}

		response.put("error-message", "Incorrect provided data");
		return ResponseEntity.status(404).body(response);
	}
}