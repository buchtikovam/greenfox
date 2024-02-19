package com.greenfox.connectionwithmysql.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "assignees")
public class Assignee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;

	@OneToMany(
		fetch = FetchType.LAZY,
		cascade = CascadeType.ALL
	)
	@JoinColumn(name = "assignee_id")
	private Set<Todo> todos;

	public Assignee() {}

	public Assignee(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
