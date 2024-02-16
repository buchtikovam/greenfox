import java.util.Scanner;
public class CountFromTo {
	public static void main(String[] args) {
		// Create a program that asks for two numbers. If the second number
		// is not greater than the first the program should print:
		// "The second number should be bigger"
		//
		// Otherwise it should output all integers between the first and
		// the second number (excluding the second number)
		//
		// Example:
		//
		// Please enter the first number: 3
		// Please enter the second number: 6
		// 3
		// 4
		// 5
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the first number: ");
		int firstNumber = scanner.nextInt();
		System.out.print("Please enter the second number: ");
		int secondNumber = scanner.nextInt();

		if (secondNumber < firstNumber) {
			System.out.print("The second number should be bigger");
		} else {
			for (int i = firstNumber; i < secondNumber; i++) {
				System.out.println(i);
			}
		}
	}
}
