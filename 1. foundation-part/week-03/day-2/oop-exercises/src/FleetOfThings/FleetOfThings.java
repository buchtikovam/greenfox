package FleetOfThings;

public class FleetOfThings {
	public static void main(String[] args) {
		Fleet fleet = new Fleet();

		Thing first = new Thing("Get milk");
		Thing second = new Thing("Remove the obstacles");
		Thing third = new Thing("Stand up");
		third.complete();
		Thing fourth = new Thing("Eat lunch");
		fourth.complete();

		fleet.add(first);
		fleet.add(second);
		fleet.add(third);
		fleet.add(fourth);

		String myString = fleet.toString();
		// - You have the `Thing` class
		// - You have the `Fleet` class
		// - You have the `FleetOfThings` class with a `main()` method
		// - Download those, use those
		// - Create a fleet in the main() method

		// - Create a fleet of things to have this output:
		// 1. [ ] Get milk
		// 2. [ ] Remove the obstacles
		// 3. [x] Stand up
		// 4. [x] Eat lunch
		System.out.println(myString);
	}
}