package Sum;

import java.util.ArrayList;
import java.util.List;

public class Sum {
	List<Integer> numbers = new ArrayList<Integer>();

	public void add(int number) {
		this.numbers.add(number);
	}

	public int sum() {
		int sum = 0;
		for (int number: this.numbers) {
			sum += number;
		}
		return sum;
	}
}
