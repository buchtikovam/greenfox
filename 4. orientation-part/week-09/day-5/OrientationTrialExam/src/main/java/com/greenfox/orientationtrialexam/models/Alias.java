package com.greenfox.orientationtrialexam.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "aliases")
@Getter @Setter
public class Alias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String alias;
	private int hitCount;
	private String secretCode;

	@ManyToOne
	@JoinColumn(name = "link_id")
	private Link link;

	public Alias(
		String alias
	) {
		this.alias = alias;
		this.hitCount = 0;
		this.secretCode = String.valueOf(new Random().nextInt(9999) + 1000);
	}

	public Alias() {
	}

	public void addHitCount() {
		this.hitCount++;
	}
}