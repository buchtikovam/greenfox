package com.greenfox.exam.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemWithoutIdDTO {
	private String name;
	private String manufacturer;
	private String category;
	private String size;
	private double unit_price;

	public ItemWithoutIdDTO(String name, String manufacturer, String category, String size, double unit_price) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.category = category;
		this.size = size;
		this.unit_price = unit_price;
	}
}
