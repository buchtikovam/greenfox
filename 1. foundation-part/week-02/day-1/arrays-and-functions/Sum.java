public class Sum {
	public static void main(String[] args) {
		// Create the usual class wrapper (Sum) and main method on your own
		// Write a function called `sum()` that returns the sum of numbers from zero
		// to the given parameter
		//
		// Example: sum(5) = 0 + 1 + 2 + 3 + 4 + 5 = 15
		sum(7);
	}

	public static int sum(int numbers) {
		int sumNum = 0;
		for (int i = 0; i <= numbers; i++) {
			sumNum += i;
		}
		System.out.print(sumNum);
		return sumNum;
	}
}
