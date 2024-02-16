package com.greenfox.backendapiexercises.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "logs")
@Getter @Setter
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private LocalDateTime createdAt;
	private String endpoint;
	private String data;

	public Log(String endpoint, String data) {
		this.endpoint = endpoint;
		this.data = data;
		this.createdAt = LocalDateTime.now();
	}

	public Log() {
	}
}
