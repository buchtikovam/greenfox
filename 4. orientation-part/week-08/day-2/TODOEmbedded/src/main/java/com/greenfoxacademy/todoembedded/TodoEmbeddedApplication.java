package com.greenfoxacademy.todoembedded;

import com.greenfoxacademy.todoembedded.models.Todo;
import com.greenfoxacademy.todoembedded.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoEmbeddedApplication implements CommandLineRunner {

	private final TodoRepository todoRepository;

	@Autowired
	public TodoEmbeddedApplication(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}


	public static void main(String... args) {
		SpringApplication.run(TodoEmbeddedApplication.class, args);
	}


	@Override
	public void run(String... args) {
		this.todoRepository.save(
			new Todo("I have to learn Object Relational Mapping")
		);
	}
}
