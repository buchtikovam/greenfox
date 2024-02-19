package Flyable;

public abstract class Vehicle {
	private String name;
	private int weightInTons;
	private int numberOfSeats;

	public Vehicle(String name, int weightInTons, int numberOfSeats) {
		this.name = name;
		this.weightInTons = weightInTons;
		this.numberOfSeats = numberOfSeats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeightInTons() {
		return weightInTons;
	}

	public void setWeightInTons(int weightInTons) {
		this.weightInTons = weightInTons;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
}
