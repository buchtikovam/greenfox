package com.greenfox.exam.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String category;
	private String size;
	private double unit_price;

	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;

	public Item(String name, String category, String size, double unit_price) {
		this.name = name;
		this.category = category;
		this.size = size;
		this.unit_price = unit_price;
	}

	public Item() {}
}