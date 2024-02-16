public class Doubling {
	public static void main(String[] args) {
		// - Create an integer variable named `baseNumber` and
		//   assign it the value of `123`
		// - Create a function called `doubleNumber()` that doubles
		//   its integer input parameter and returns that doubled value
		// - Print the result of `doubleNumber(baseNumber)`
		int baseNumber = 123;
		doubleNumber(baseNumber);
	}

	public static int doubleNumber(int num) {
		int doubled = 2 * num;
		System.out.println(doubled);
		return doubled;
	}
}