package com.greenfox.exam.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "manufacturers")
@Getter
@Setter
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany(
		mappedBy = "manufacturer",
		cascade = CascadeType.ALL
	)
	private Set<Item> itemSet;

	public Manufacturer(String name) {
		this.name = name;
	}

	public Manufacturer() {}
}