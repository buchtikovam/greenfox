import java.util.Scanner;
public class PrintBigger {
	public static void main(String[] args) {
		// Write a program that asks for two numbers and prints the bigger one.
		// If they are equal, it prints the second one.
		//
		// Example
		//
		// Please enter a number: 5
		// Please enter a number: 13
		// 13
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int numOne = scanner.nextInt();
		System.out.print("Please enter a number: ");
		int numTwo = scanner.nextInt();

		if (numOne > numTwo) {
			System.out.println(numOne);
		} else if (numOne == numTwo) {
			System.out.println(numTwo);
		} else {
			System.out.println(numTwo);
		}
	}
}
