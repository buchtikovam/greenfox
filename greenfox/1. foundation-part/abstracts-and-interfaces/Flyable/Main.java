package Flyable;

public class Main {
	public static void main(String[] args) {
		Bird chicken = new Bird("Chicken Henny");
		Helicopter helicopter = new Helicopter(
			"Pinkcopter",
			10,
			4
		);

		chicken.takeOff();
		chicken.fly();
		chicken.land();
		System.out.println();
		helicopter.takeOff();
		helicopter.fly();
		helicopter.land();
	}
}
