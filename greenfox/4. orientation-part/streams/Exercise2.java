import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise2 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(
			1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14
		);

		List<Integer> expectedOutput = Arrays.asList(
			1, 9, 144, 361, 36, 81, 100, 196
		);

		System.out.println(getSquareOfPositiveInt(numbers));
	}

	public static List<Integer> getSquareOfPositiveInt(List<Integer> numbers) {
		List<Integer> squaredNum = new ArrayList<>();

		numbers.stream()
			.filter(num -> num > 0)
			.map(num -> num * num)
			.forEach(squaredNum::add);

		return squaredNum;
	}
}
