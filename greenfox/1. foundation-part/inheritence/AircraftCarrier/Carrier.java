package AircraftCarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
	private final List<Aircraft> allAircrafts = new ArrayList<>();
	private int storeOfAmmo;
	private int healthPoints;

	public Carrier(int storeOfAmmo, int healthPoints) {
		this.storeOfAmmo = storeOfAmmo;
		this.healthPoints = healthPoints;
	}

	public int getStoreOfAmmo() {
		return storeOfAmmo;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void addAircraft(Aircraft aircraft) {
		allAircrafts.add(aircraft);
	}

	public void fill() {
		if (storeOfAmmo < 1) {
			throw new RuntimeException("Not enough ammo to fill aircrafts");
		}

		for (Aircraft aircraft : allAircrafts) {
			if (aircraft.isPriority()) {
				storeOfAmmo = aircraft.refillAmmo(storeOfAmmo);
			}
		}

		for (Aircraft aircraft : allAircrafts) {
			if (!aircraft.isPriority()) {
				storeOfAmmo = aircraft.refillAmmo(storeOfAmmo);
			}
		}
	}

	public void fight(Carrier targetCarrier) {
		int totalDamage = 0;
		for (Aircraft aircraft : allAircrafts) {
			totalDamage += aircraft.fight();
		}
		targetCarrier.takeDamage(totalDamage);
	}

	private void takeDamage(int damage) {
		healthPoints -= damage;
		if (healthPoints <= 0) {
			healthPoints = 0;
		}
	}

	public String getStatus() {
		StringBuilder status = new StringBuilder();
		status.append("HP: ").append(healthPoints);
		status.append(", Aircraft count: ").append(allAircrafts.size());
		status.append(", Ammo Storage: ").append(storeOfAmmo);
		status.append(", Total damage: ").append(getTotalDamage()).append("\n");

		status.append("Aircrafts:\n");
		for (Aircraft aircraft : allAircrafts) {
			status.append(aircraft.getStatus()).append("\n");
		}

		if (healthPoints == 0) {
			status.append("It's dead Jim :(");
		}

		return status.toString();
	}

	private int getTotalDamage() {
		int totalDamage = 0;
		for (Aircraft aircraft : allAircrafts) {
			totalDamage += aircraft.getDamage();
		}
		return totalDamage;
	}
}