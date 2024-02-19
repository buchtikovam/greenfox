public class Factorial {
	public static void main(String[] args) {
		// Create the usual class wrapper (Factorial) and main method on your own

		// Create a function called `calculateFactorial()`
		// that returns the factorial of its input
		//
		// Example: calculateFactorial(5) = 1 * 2 * 3 * 4 * 5 = 120
		calculateFactorial(5);
	}
	public static int calculateFactorial(int numbers) {
		int factorial = 1;
		for (int i = 1; i <= numbers ; i++) {
			factorial *= i;
		}
		System.out.print(factorial);
		return factorial;
	}
}
