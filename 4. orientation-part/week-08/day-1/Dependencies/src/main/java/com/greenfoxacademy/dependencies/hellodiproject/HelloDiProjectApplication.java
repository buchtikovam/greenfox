package com.greenfoxacademy.dependencies.hellodiproject;

import com.greenfoxacademy.dependencies.hellodiproject.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloDiProjectApplication implements CommandLineRunner {

	private final Printer printer;

	@Autowired
	public HelloDiProjectApplication(Printer printer) {
		this.printer = printer;
	}

	public static void main(String... args) {
		SpringApplication.run(HelloDiProjectApplication.class, args);
	}

	@Override
	public void run(String... args) {
		printer.log("hello");
	}
}