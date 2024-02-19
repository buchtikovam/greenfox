package com.greenfox.backendapiexercises.controllers;

import com.greenfox.backendapiexercises.models.Log;
import com.greenfox.backendapiexercises.repositories.LogRepository;
import com.greenfox.backendapiexercises.requestFilters.ArraysRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class MainRestController {

	private final LogRepository logRepository;

	@Autowired
	public MainRestController(LogRepository logRepository) {
		this.logRepository = logRepository;
	}


	@GetMapping("/doubling")
	public ResponseEntity<Map<String, Object>> doubleNum(
		@RequestParam(required = false) Integer input
	) {
		Map<String, Object> response = new HashMap<>();

		if (input == null) {
			response.put("error", "Please provide an input!");
			return ResponseEntity.status(400).body(response);
		}

		int result = input * 2;
		response.put("received", input);
		response.put("result", result);
		this.logRepository.save(new Log("/doubling", "input=" + input));
		return ResponseEntity.ok(response);
	}



	@GetMapping("/greeter")
	public ResponseEntity<Map<String, Object>> greet(
		@RequestParam(required = false) String name,
		@RequestParam(required = false) String title
	) {
		Map<String, Object> response = new HashMap<>();

		if ((name == null || name.isEmpty()) && (title == null || title.isEmpty())) {
			response.put("error", "Please provide a name and a title!");
			return ResponseEntity.status(400).body(response);
		}

		if (name == null || name.isEmpty()) {
			response.put("error", "Please provide a name!");
			return ResponseEntity.status(400).body(response);
		}

		if (title == null || title.isEmpty()) {
			response.put("error", "Please provide a title!");
			return ResponseEntity.status(400).body(response);
		}

		response.put(
			"welcome_message",
			"Oh, hi there " + name + ", my dear " + title + "!"
		);

		this.logRepository.save(
			new Log(
				"/greeter",
				Arrays.asList(
					"name=" + name,
					"title=" + title
				).toString()
			)
		);

		return ResponseEntity.ok(response);
	}



	@GetMapping("/appenda/{appendable}")
	public ResponseEntity<Map<String, Object>> appendA(
		@PathVariable String appendable
	) {
		Map<String, Object> response = new HashMap<>();

		if (appendable.isEmpty()) {
			response.put("error", "No string provided");
			return ResponseEntity.status(404).body(response);
		}

		response.put("appended", appendable + "a");
		this.logRepository.save(
			new Log(
				"/appenda",
				"input=" + appendable
			)
		);

		return ResponseEntity.ok(response);
	}



	@PostMapping("/arrays")
	public ResponseEntity<Map<String, Object>> arrays(
		@Valid @RequestBody ArraysRequestFilter arraysRequestFilter
	) {
		Map<String, Object> response = new HashMap<>();

		if (arraysRequestFilter.getWhat() == null && arraysRequestFilter.getNumbers() == null) {
			response.put("error", "Please provide numbers and commands!");
			return ResponseEntity.status(422).body(response);
		}

		if (arraysRequestFilter.getWhat() == null) {
			response.put("error", "Please provide what to do with the numbers!");
			return ResponseEntity.status(422).body(response);
		}

		if (arraysRequestFilter.getNumbers() == null) {
			response.put("error", "Please provide numbers!");
			return ResponseEntity.status(422).body(response);
		}

		String what = arraysRequestFilter.getWhat();
		int[] numbers = arraysRequestFilter.getNumbers();
		int result;

		switch (what) {
			case "sum":
				result = Arrays.stream(numbers).sum();
				this.logRepository.save(createLog(what, numbers));
				break;

			case "multiply":
				result = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
				this.logRepository.save(createLog(what, numbers));
				break;

			case "double":
				int[] doubledArray = Arrays.stream(numbers).map(num -> num * 2).toArray();
				response.put("result", doubledArray);
				this.logRepository.save(createLog(what, numbers));
				return ResponseEntity.ok(response);

			default:
				response.put(
					"error",
					"Please provide a valid operation for 'what' (sum, multiply, double)!"
				);
				return ResponseEntity.status(422).body(response);
		}

		response.put("result", result);
		return ResponseEntity.ok(response);
	}

	private Log createLog(String what, int[] numbers) {
		return new Log(
			"/arrays",
			Arrays.asList(
				"what=" + what,
				"numbers=" + Arrays.toString(numbers)
			).toString()
		);
	}



	@GetMapping("/log")
	public ResponseEntity<Map<String, Object>> showLogs() {
		// add all into list
		List<Log> logEntries = this.logRepository.findAll();
		int entryCount = logEntries.size();

		// format logs into map, collecting them in one big map
		List<Map<String, Object>> formattedLogs = logEntries.stream()
			.map(log -> {
				// each log has its own map
				Map<String, Object> logMap = new HashMap<>();
				logMap.put("id", log.getId());
				logMap.put("endpoint", log.getEndpoint());
				logMap.put("data", log.getData());
				return logMap;
			}).collect(Collectors.toList());

		Map<String, Object> response = new HashMap<>();
		response.put("entries", formattedLogs);
		response.put("entry_count", entryCount);

		return ResponseEntity.ok(response);
	}
}