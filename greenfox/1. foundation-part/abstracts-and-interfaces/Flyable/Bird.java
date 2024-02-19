package Flyable;

public class Bird extends Zoo.Bird implements Flyable{
	public Bird(String name) {
		super(name);
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
				+ " lands to get a snack!"
		);
	}
}
