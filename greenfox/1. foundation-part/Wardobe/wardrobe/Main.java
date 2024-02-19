package wardrobe;

public class Main {
	public static void main(String[] args) throws Exception {
		Wardrobe wardrobe = new Wardrobe();

		wardrobe.addCloth(new Overwear(
			"jacket",
			"blue",
			0
		));

		wardrobe.addCloth(new Overwear(
			"hoodie",
			"black",
			5
		));

		wardrobe.addCloth(new Underwear(
			"sock",
			"white",
			1
		));

		wardrobe.printInfo();
		System.out.println();

		wardrobe.washAllClothes();
		System.out.println();

		wardrobe.printInfo();
	}
}
