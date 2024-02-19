public class MaximumFinder {
	// Write a function which returns the largest element
	// of an array using recursion.
	public static void main(String[] args) {
		int[] myArray = new int[] {1, 2, 5, 4, 8};
		System.out.println(maxInArray(myArray));
	}

	public static int maxInArray(int[] array) {
		return maxInArrayRecursive(array, array.length - 1, Integer.MIN_VALUE);
	}

	private static int maxInArrayRecursive(int[] array, int index, int currentMax) {
		if (index < 0) {
			return currentMax;
		}
		int currentValue = array[index];
		if (currentValue > currentMax) {
			currentMax = currentValue;
		}
		return maxInArrayRecursive(array, index - 1, currentMax);
		}
	}
