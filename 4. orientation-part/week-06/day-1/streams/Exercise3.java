import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise3 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(
			3, 9, 2, 8, 6, 5
		);

		List<Integer> expectedOutput = Arrays.asList(
			9, 8, 6, 5
		);

		System.out.println(getNumbersWithSquareGreaterThan(numbers, 20));
	}

	public static List<Integer> getNumbersWithSquareGreaterThan(List<Integer> numbers, int condition) {
		List<Integer> squaredNum = new ArrayList<>();

		numbers.stream()
			.filter(num -> num * num > condition)
			.forEach(squaredNum::add);

		return squaredNum;
	}
}
