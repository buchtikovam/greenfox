package com.greenfox.orientationtrialexam.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "links")
@Getter @Setter
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String url;

	@OneToMany(
		fetch = FetchType.LAZY,
		cascade = CascadeType.ALL
	)
	@JoinColumn(name = "link_id")
	private Set<Alias> aliases;

	public Link(String url) {
		this.url = url;
	}

	public Link() {
	}
}