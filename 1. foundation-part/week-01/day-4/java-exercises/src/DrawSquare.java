import java.util.Scanner;
public class DrawSquare {
	public static void main(String[] args) {
		// Write a program that reads a number from the standard input and
		// then draws a square of the specified size
		//
		// Example:
		//
		// Please enter the square size: 6
		// %%%%%%
		// %    %
		// %    %
		// %    %
		// %    %
		// %%%%%%
		//
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the square size: ");
		int size = scanner.nextInt();
		draw(size);
	}

	public static void draw(int size){
		// Write your code to draw the square here
		String symbol = "%";
		for (int rows = 1; rows <= size; rows++) {
			if (rows == 1 || rows == size) {
				for (int character = 1; character <= size; character++) {
					System.out.print(symbol);
				}
			} else {
				System.out.print(symbol);
				for (int space = 1; space <= size - 2; space++) {
					System.out.print(" ");
				}
				System.out.print(symbol);
			}

			System.out.println();
		}
	}
}
