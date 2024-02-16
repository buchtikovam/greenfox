package com.greenfoxacademy.programmerfoxclub.models;

import java.util.List;

public class Food {
	private int deceaseTime;
	private String name;

	public Food(String name, int deceaseTime) {
		this.name = name;
		this.deceaseTime = deceaseTime;
	}

	public int getDeceaseTime() {
		return deceaseTime;
	}

	public void setDeceaseTime(int deceaseTime) {
		this.deceaseTime = deceaseTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
