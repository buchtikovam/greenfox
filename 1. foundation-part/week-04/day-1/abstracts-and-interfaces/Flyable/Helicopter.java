package Flyable;

public class Helicopter extends Vehicle implements Flyable {

	public Helicopter(String name, int weightInTons, int numberOfSeats) {
		super(name, weightInTons, numberOfSeats);
	}

	@Override
	public void takeOff() {
		System.out.println(
			getName()
			+ " is taking off!"
		);
	}

	@Override
	public void fly() {
		System.out.println(
			getName()
			+ " is flying high!"
		);
	}

	@Override
	public void land() {
		System.out.println(
			getName()
				+ " landing."
		);
	}
}
