package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {
	private String name;
	private int id;
	private String currentFood;
	private String currentDrink;
	private List<String> learnedTricks;

	public Fox(String name) {
		this.name = name;
		this.currentFood = "nuggets";
		this.currentDrink = "water";
		this.learnedTricks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentFood() {
		return currentFood;
	}

	public void setCurrentFood(String currentFood) {
		this.currentFood = currentFood;
	}

	public String getCurrentDrink() {
		return currentDrink;
	}

	public void setCurrentDrink(String currentDrink) {
		this.currentDrink = currentDrink;
	}

	public List<String> getLearnedTricks() {
		return learnedTricks;
	}

	public void setLearnedTricks(List<String> learnedTricks) {
		this.learnedTricks = learnedTricks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addTrick(String trick) {
		this.learnedTricks.add(trick);
	}
}
