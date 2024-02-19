import java.util.Scanner;
public class AverageOfInput {
	public static void main(String[] args) {
		// Write a program prompts the user for 5 integers in a row,
		// then it prints their sum and their average:
		//
		// Please enter a number: 3
		// Please enter a number: 7
		// Please enter a number: 1
		// Please enter a number: 6
		// Please enter a number: 5
		// Sum: 22, Average: 4.4
		//
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int numOne = scanner.nextInt();
		System.out.print("Please enter a number: ");
		int numTwo = scanner.nextInt();
		System.out.print("Please enter a number: ");
		int numThree = scanner.nextInt();
		System.out.print("Please enter a number: ");
		int numFour = scanner.nextInt();
		System.out.print("Please enter a number: ");
		int numFive = scanner.nextInt();

		int sumOfNumbers = numOne + numTwo + numThree + numFour + numFive;
		double averageOfNumbers = (double) sumOfNumbers / 5;

		System.out.println("Sum: " + sumOfNumbers + ", Average: " + averageOfNumbers);
	}
}
