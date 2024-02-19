package com.greenfoxacademy.basicwebshop.models;

public class ShopItem {
	private String name;
	private String description;
	private String type;
	private double price;
	private int quantityOfStock;
	private static int counter = 1;
	private int id;

	public ShopItem(String name, String description, String type, double price, int quantityOfStock) {
		this.id = counter;
		this.name = name;
		this.description = description;
		this.type = type;
		this.price = price;
		this.quantityOfStock = quantityOfStock;
		counter++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityOfStock() {
		return quantityOfStock;
	}

	public void setQuantityOfStock(int quantityOfStock) {
		this.quantityOfStock = quantityOfStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
}
