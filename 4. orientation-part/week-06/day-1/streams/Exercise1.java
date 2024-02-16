import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(
			1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14
		);

		List<Integer> expectedOutput = Arrays.asList(
			-2, -4, -8, 12, 6, 10, 14
		);

		System.out.println(GetEvenNumbers(numbers));
	}

	public static List<Integer> GetEvenNumbers(List<Integer> numbers) {
		List<Integer> evenNum = new ArrayList<>();
		numbers.stream()
			.filter(num -> num % 2 == 0)
			.forEach(evenNum::add);
		return evenNum;
	}
}
