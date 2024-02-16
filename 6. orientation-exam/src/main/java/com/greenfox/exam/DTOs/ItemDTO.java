package com.greenfox.exam.DTOs;

import com.greenfox.exam.models.Item;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDTO {
	private Long id;
	private String name;
	private String manufacturer;
	private String category;
	private String size;
	private double unit_price;

	public ItemDTO(Item item) {
		this.id = item.getId();
		this.name = item.getName();
		this.manufacturer = item.getManufacturer().getName();
		this.category = item.getCategory();
		this.size = item.getSize();
		this.unit_price = item.getUnit_price();
	}
}
