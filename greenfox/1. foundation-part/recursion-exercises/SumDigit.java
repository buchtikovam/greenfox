public class SumDigit {
	public static void main(String[] args) {
		// Given a non-negative integer n, return the sum of its digits recursively
		// (without loops).
		//
		// Hint
		//
		// Mod (%) by 10 yields the rightmost digit (e.g. 126 % 10 is 6)
		//
		// Divide (/) by 10 removes the rightmost digit (e.g. 126 / 10 is 12).
		System.out.println(sumOfDigits(1001));
	}

	public static int sumOfDigits(int n) {
		if (n < 10) {
			return n;
		}

		int firstDigit = Integer.parseInt(
			// Převede char na string
			String.valueOf(
				// Vezme první číslici v čísle jako char
				String.valueOf(n).charAt(0)
			)
		);

		int restOfDigit = Integer.parseInt(
			// Tady vezmeme číslo a odebereme mu první znak
			String.valueOf(n).substring(1)
		);

		// Tady sečteme první čísli s další (n) první číslicí
		return firstDigit + sumOfDigits(restOfDigit);
	}
}
