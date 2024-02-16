package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.models.Drink;
import com.greenfoxacademy.programmerfoxclub.models.Food;
import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.models.Trick;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController
{
	private final List<Fox> foxes = new ArrayList<>(
		Collections.singletonList(new Fox("Pepa"))
	);

	private final List<Food> foods = new ArrayList<>(Arrays.asList(
			new Food("chicken", 5),
			new Food("nuggets", 3),
			new Food("sausage", 7),
			new Food("apple", 14),
			new Food("human arm", 3),
			new Food("potato", 20)
		)
	);

	private final List<Drink> drinks = new ArrayList<>(Arrays.asList(
			new Drink("water"),
			new Drink("soda"),
			new Drink("orange juice"),
			new Drink("blood of his enemies"),
			new Drink("vodka"),
			new Drink("tea")
		)
	);

	private final List<Trick> tricks = new ArrayList<>(Arrays.asList(
			new Trick("kung fu fighting"),
			new Trick("hack into bank accounts"),
			new Trick("run faster than the wind"),
			new Trick("ride horses"),
			new Trick("play Yasuo in League of Legends"),
			new Trick("bake a cake")
		)
	);

	// Show main page
	@RequestMapping(
		value = "/",
		method = RequestMethod.GET
	)
	public String index(
		@RequestParam(required = false) String foxName,
		Model model
	) {
		if (foxName == null || foxName.isEmpty()) {
			return "redirect:/login";
		}

		Fox fox = getFoxByName(foxName);
		if (fox == null) {
			return "redirect:/login?error=Name '" + foxName + "' does not exist!";
		}

		model.addAttribute("fox", fox);
		return "index";
	}



	// Display login page
	@RequestMapping(
		value = "/login",
		method = RequestMethod.GET
	)
	public String showLogin(
		@RequestParam(required = false) String error,
		Model model
	) {
		model.addAttribute("error", error);
		return "login";
	}



	// From login, redirect to main page with name (and error) in URL
	@RequestMapping(
		value = "/login",
		method = RequestMethod.POST
	)
	public String returnName(
		@RequestParam String foxName
	) {
		//checking if foxName already exists
		if (getFoxByName(foxName) != null) {
			return "redirect:/login?error=Name '" + foxName + "' already exists!";
		}

		this.foxes.add(new Fox(foxName));
		return "redirect:/?foxName=" + foxName;
	}



	// Changing current drink and food
	@RequestMapping(
		value = "/fridge",
		method = RequestMethod.GET
	)
	public String showFridge(
		@RequestParam(required = false) String foxName,
		Model model
	) {
		Fox fox = getFoxByName(foxName);
		if (fox == null) {
			return "redirect:/login?error=Name '" + foxName + "' does not exist!";
		}

		model.addAttribute("foods", this.foods);
		model.addAttribute("drinks", this.drinks);
		model.addAttribute("fox", fox);
		return "fridge";
	}



	// Saving current food and drink
	@RequestMapping(
		value = "/fridge",
		method = RequestMethod.POST
	)
	public String selectFood(
		@RequestParam(required = false) String foxName,
		@RequestParam String food,
		@RequestParam String drink
	) {
		Fox fox = getFoxByName(foxName);
		if (fox == null) {
			return "redirect:/login?error=Name '" + foxName + "' does not exist!";
		}

		fox.setCurrentFood(food);
		fox.setCurrentDrink(drink);

		return "redirect:/?foxName=" + foxName;
	}



	// Learning new tricks
	@RequestMapping(
		value = "/school",
		method = RequestMethod.GET
	)
	public String showSchool(
		@RequestParam(required = false) String foxName,
		@RequestParam(required = false) String error,
		Model model
	) {
		Fox fox = getFoxByName(foxName);
		if (fox == null) {
			return "redirect:/login?error=Name '" + foxName + "' does not exist!";
		}

		model.addAttribute("tricks", this.tricks);
		model.addAttribute("error", error);
		model.addAttribute("fox", fox);
		return "school";
	}



	// Saving current trick
	@RequestMapping(
		value = "/school",
		method = RequestMethod.POST
	)
	public String selectTrick(
		@RequestParam String foxName,
		@RequestParam String trick
	) {
		Fox fox = getFoxByName(foxName);
		if (fox == null) {
			return "redirect:/login?error=Name '" + foxName + "' does not exist!";
		}

		if (fox.getLearnedTricks().contains(trick)) {
			return "redirect:/school?foxName=" + foxName + "&error=" + foxName + " already knows this trick!";
		}

		fox.addTrick(trick);
		return "redirect:/?foxName=" + foxName;
	}


	public Fox getFoxByName(String name) {
		for (Fox fox : foxes) {
			if (fox.getName().equals(name)) {
				return fox;
			}
		}

		return null;
	}
}
