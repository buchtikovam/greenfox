public class Bunnies {
	public static void main(String[] args) {
		// We have a number of bunnies and each bunny has two big floppy ears. Write
		// a recursive method (no loops or multiplication) which takes the number of
		// bunnies as its sole parameter and returns the total number of ears
		// the bunnies have. The method should be able to handle invalid input
		// (e.g. negative numbers)
		//
		System.out.println(calculateEars(6));
		}

	public static int calculateEars(int n) {
		if (n <= 0) {
			return 0;
		} else {
			return 2 + calculateEars(n - 1);
		}
	}
}
