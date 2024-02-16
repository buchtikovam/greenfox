import java.util.Scanner;
public class DrawPyramid {
	public static void main(String[] args) {
		// Write a program that reads a number from the standard input and
		// then draws a pyramid of the specified height
		//
		// Example:
		//
		// Please enter the pyramid height: 4
		//    *
		//   ***
		//  *****
		// *******
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the pyramid height: ");
		int height = scanner.nextInt();
		draw(height);
	}

	public static void draw(int height){
		// Write your code to draw the pyramid here
		for (int rows = 1; rows <= height; rows++) {
			String symbolPyramid = "*";
			String symbolSpace = " ";

			// Creating loop to write spaces
			for (int space = height - 1; space >= rows; space--) {
				System.out.print(symbolSpace);
			}

			// Creating loop to write symbols
			int characters = 2 * rows - 1;
			repeat(symbolPyramid, characters);

			System.out.println();
		}
	}

	public static void repeat(
			String symbol,
			int count
	) {
		for (int i = 1; i <= count; i++) {
			System.out.print(symbol);
		}
	}
}
