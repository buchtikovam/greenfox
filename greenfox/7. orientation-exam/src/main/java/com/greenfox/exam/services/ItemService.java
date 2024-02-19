package com.greenfox.exam.services;

import com.greenfox.exam.models.Item;
import com.greenfox.exam.models.TotalOfItem;
import java.util.List;
import java.util.Optional;

public interface ItemService {

	List<Item> findAll();

	Optional<Item> findById(Long id);

	Item save(Item item);

	void delete(Item item);

	List<String> getUniqueItems(List<Item> itemList);

	List<String> getAllowedSizes();

	List<String> getAllowedCategories();

	List<Item> getItemsBySize(List<Item> itemList, String size);

	List<Item> getItemsByManufacturer(List<Item> itemList, String manufacturer);

	List<Item> getItemsByNameAndSize(String name, String size);

	List<Item> getItemsBySizeAndManufacturer(List<Item> itemList, String size, String manufacturer);

	TotalOfItem createTotalOfItem(List<Item> matchedItems);
}
