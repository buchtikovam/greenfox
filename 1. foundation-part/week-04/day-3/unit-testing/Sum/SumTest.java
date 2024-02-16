package Sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

	@Test
	public void testEmptyList() {
		Sum sum = new Sum();
		assertEquals(0, sum.sum());
	}

	@Test
	public void testWithOneElement() {
		Sum sum = new Sum();
		int number = 5;
		sum.add(number);
		assertEquals(number, sum.sum());
	}

	@Test
	public void testWithMultipleElements() {
		Sum sum = new Sum();
		int number = 5;
		int number2 = 1;
		int number3 = 2;
		int expectedSum = number + number2 + number3;
		sum.add(number);
		sum.add(number2);
		sum.add(number3);
		assertEquals(expectedSum, sum.sum());
	}
}