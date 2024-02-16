package com.greenfoxacademy.dependencies.usefulutilities.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UtilityService {

	private final List<String> colors;
	private final Random random;

	public UtilityService() {
		colors = new ArrayList<>();
		colors.add("red");
		colors.add("blue");
		colors.add("lime");
		colors.add("orange");
		colors.add("magenta");
		random = new Random();
	}

	public String generateRandomColor() {
		return colors.get(random.nextInt(colors.size()));
	}


	public String validateEmail(String email) {
		if (email.contains("@") && email.contains(".")) {
			return email + " is a valid email address";
		}
		return email + " is not a valid email address";
	}

	public String validationColor(String email) {
		if (validateEmail(email).endsWith("is a valid email address")) {
			return "green";
		}
		return "red";
	}
}
