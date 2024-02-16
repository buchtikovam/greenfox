package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController extends AtomicLong {

	final AtomicLong counter = new AtomicLong(1);

	@GetMapping("/greeting")
	public Greeting getGreeting(
		@RequestParam(value = "name")
		String name
	) {
		return new Greeting(
			this.counter.getAndIncrement(),
			"Hello, " + name + "!"
		);
	}
}
