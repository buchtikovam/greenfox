import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise4 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(
			1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14
		);

		double expectedOutput = 22.0/6.0;

		System.out.println(getAverageIfOddAndEvenNumbers(numbers));
	}

	public static List<Integer> getAverageIfOddAndEvenNumbers(List<Integer> numbers) {
		List<Integer> squaredNum = new ArrayList<>();

		numbers.stream()
			.filter(num -> num % 2 == 0)
			.
			.forEach(squaredNum::add);

		return squaredNum;
	}
}
