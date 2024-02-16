package com.greenfox.exam.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TotalOfItem {
	private String name;
	private String manufacturer;
	private String category;
	private int quantity;
	private double subtotal_price;

	public TotalOfItem(
		String name,
		String manufacturer,
		String category,
		String quantity,
		double subtotal_price
	) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.category = category;
		this.quantity = 0;
		this.subtotal_price = 0;
	}

	public TotalOfItem() {}

	public void addQuantity() {
		this.quantity++;
	}

	public void addSubtotal_price(double number) {
		this.subtotal_price += number;
	}
}