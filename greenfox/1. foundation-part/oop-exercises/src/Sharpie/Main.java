package Sharpie;

public class Main {
	public static void main(String[] args) {
		Sharpie sharpie1 = new Sharpie(
			"blue",
			10
		);

		Sharpie sharpie2 = new Sharpie(
			"red",
			5
		);

		sharpie1.use();
		sharpie2.use();
	}
}
