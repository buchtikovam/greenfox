package RotateMatrix;

import java.util.Arrays;

public class RotateMatrix {
	public static void main(String[] args) {

		int[][] inputMatrix = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		printMatrix(rotateMatrix(inputMatrix));
	}

	public static int[][] rotateMatrix(int[][] matrix) {

		int[][] rotatedMatrix = new int[matrix.length][matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				rotatedMatrix[j][matrix.length - 1 - i] = matrix[i][j];
			}
		}

		return rotatedMatrix;
	}

	public static void printMatrix(int[][] matrix) {

		for (int[] row : matrix) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}