package com.greenfox.exam.services;

import com.greenfox.exam.models.Item;
import com.greenfox.exam.models.TotalOfItem;
import com.greenfox.exam.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public List<Item> findAll() {
		return this.itemRepository.findAll();
	}

	@Override
	public Optional<Item> findById(Long id) {
		return this.itemRepository.findById(id);
	}

	@Override
	public Item save(Item item) {
		return this.itemRepository.save(item);
	}

	@Override
	public void delete(Item item) {
		this.itemRepository.delete(item);
	}

	@Override
	public List<String> getUniqueItems(List<Item> itemList) {
		List<String> uniqueNames = new ArrayList<>();

		for (Item item : itemList) {
			String name = item.getName();
			if (!uniqueNames.contains(name)) {
				uniqueNames.add(name);
			}
		}

		return uniqueNames;
	}

	@Override
	public List<String> getAllowedSizes() {
		List<String> sizes = new ArrayList<>();
		sizes.add("XS");
		sizes.add("S");
		sizes.add("M");
		sizes.add("L");
		sizes.add("XL");
		return sizes;
	}


	@Override
	public List<Item> getItemsByManufacturer(List<Item> itemList, String manufacturer) {
		List<Item> matchedItems = new ArrayList<>();

		for (Item item : itemList) {
			String name = item.getManufacturer().getName();

			if (name.equals(manufacturer)) {
				matchedItems.add(item);
			}
		}

		return matchedItems;
	}


	@Override
	public List<Item> getItemsBySize(List<Item> itemList, String size) {
		List<Item> matchedItems = new ArrayList<>();

		for (Item item : itemList) {
			String foundSize = item.getSize();

			if (foundSize.equals(size)) {
				matchedItems.add(item);
			}
		}

		return matchedItems;
	}


	@Override
	public List<Item> getItemsBySizeAndManufacturer(List<Item> itemList, String size, String manufacturer) {
		List<Item> matchedItems = new ArrayList<>();

		for (Item item : itemList) {
			String foundSize = item.getSize();
			String foundManufacturer = item.getManufacturer().getName();

			if (foundSize.equals(size) &&
				foundManufacturer.equals(manufacturer)
			) {
				matchedItems.add(item);
			}
		}

		return matchedItems;
	}


	@Override
	public TotalOfItem createTotalOfItem(List<Item> matchedItems) {
		TotalOfItem totalOfItem = new TotalOfItem();
		for (Item item : matchedItems) {
			totalOfItem.setName(item.getName());
			totalOfItem.setCategory(item.getCategory());
			totalOfItem.setManufacturer(item.getManufacturer().getName());
			totalOfItem.setCategory(item.getCategory());
			totalOfItem.addQuantity();
			totalOfItem.addSubtotal_price(item.getUnit_price());
		}

		return totalOfItem;
	}


	@Override
	public List<String> getAllowedCategories() {
		List<String> categories = new ArrayList<>();
		categories.add("sweaters");
		categories.add("skirts");
		categories.add("blouses");
		categories.add("dresses");
		categories.add("pants");
		categories.add("shirts");
		categories.add("t-shirts");
		categories.add("jackets");
		categories.add("coats");
		categories.add("shoes");
		return categories;
	}


	@Override
	public List<Item> getItemsByNameAndSize(String name, String size) {
		List<Item> matchedItems = new ArrayList<>();

		for (Item item : this.itemRepository.findAll()) {
			String foundName = item.getName();
			String foundSize = item.getSize();

			if (foundName.equals(name) && foundSize.equals(size)) {
				matchedItems.add(item);
			}
		}

		return matchedItems;
	}
}