package com.greenfox.connectionwithmysql.models;

import javax.persistence.*;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private String description;
	private boolean done;
	private boolean urgent;

	public Todo(String title, String content, String description, boolean done, boolean urgent) {
		this.title = title;
		this.content = content;
		this.description = description;
		this.done = done;
		this.urgent = urgent;
	}

	public Todo() {
	}

	public String getTitle() {
		return title;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public boolean isDone() {
		return done;
	}

	public String getContent() {
		return content;
	}

	public String getDescription() {
		return description;
	}
}
