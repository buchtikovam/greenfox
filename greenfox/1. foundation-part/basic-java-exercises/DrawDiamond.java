import java.util.Scanner;
public class DrawDiamond {
	public static void main(String[] args) {
		// Write a program that reads a number from the standard input and
		// then draws a diamond of the specified height
		//
		// Example:
		//
		// Please enter the diamond height: 4
		//    *
		//   ***
		//  *****
		// *******
		//  *****
		//   ***
		//    *
		//
		// Note: the height of the diamond is taken from its base
		// (where it is the widest) to the top.
		// The total number of lines produced is 2*height-1
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the diamond height: ");
		int size = scanner.nextInt();
		draw(size);
	}

	public static void draw(int size){
		// Write your code to draw the diamond here
		for (int rows = 1; rows <= size; rows++) {
			int characters = 2 * rows - 1;

			for (int space = size - 1; space >= rows; space--) {
				System.out.print(" ");
			}

			for (int character = 1; character <= characters; character++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int rows = size - 1; rows >= 1 ; rows--) {
			int characters = 2 * rows - 1;
			for (int space = size - 1; space >= rows; space--) {
				System.out.print(" ");
			}

			for (int character = 1; character <= characters; character++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
//my brain isn't braining anymore
