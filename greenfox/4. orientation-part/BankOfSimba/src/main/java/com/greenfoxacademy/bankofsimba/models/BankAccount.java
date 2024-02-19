package com.greenfoxacademy.bankofsimba.models;

import java.text.DecimalFormat;

public class BankAccount {
	private String name;
	private String animalType;
	private boolean isKing;
	private boolean isGood;
	private int id;
	private double balance;
	private static int counter = 1;

	public int getId() {
		return id;
	}

	public BankAccount(String name, int balance, String animalType, boolean isKing, boolean isGood) {
		this.id = counter;
		this.name = name;
		this.balance = balance;
		this.animalType = animalType;
		this.isKing = isKing;
		this.isGood = isGood;
		counter++;
	}

	public String getName() {
		return name;
	}

	public String getBalance() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(this.balance);
	}

	public String getAnimalType() {
		return animalType;
	}

	public boolean isKing() {
		return this.isKing;
	}

	public boolean isGood() {
		return this.isGood;
	}

	public void addBalance(int balance) {
		this.balance += balance;
	}
}
