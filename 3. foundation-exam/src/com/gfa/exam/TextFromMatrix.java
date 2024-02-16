package com.gfa.exam;

public class TextFromMatrix {
	public static void main(String[] args) {

		char[][] matrix = {
			{'h', 'p', 'e'},
			{'k', 'l', 'a'},
			{'l', 'm', 'o'}
		};

		System.out.println(extractFrom(matrix));
	}

	public static String extractFrom(char[][] matrix) {

		if (matrix == null) {
			throw new IllegalArgumentException();
		}

		StringBuilder result = new StringBuilder();

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (row % 2 == 0 && column % 2 == 0) {
					result.append(matrix[row][column]);
				} else if (row % 2 != 0 && column % 2 != 0) {
					result.append(matrix[row][column]);
				}
			}
		}

		return result.toString();
	}
}
