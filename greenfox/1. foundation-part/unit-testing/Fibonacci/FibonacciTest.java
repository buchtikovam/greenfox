package Fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
	@Test
	public void testFibonacciCorrectOutput() {
		Fibonacci fibonacci = new Fibonacci();
		int input = 8;
		int expectedOutput = 21;
		assertEquals(expectedOutput, fibonacci.fib(input));
	}

	@Test
	public void testFibonacciInputZero() {
		Fibonacci fibonacci = new Fibonacci();
		int input = 0;
		int expectedOutput = 0;
		assertEquals(expectedOutput, fibonacci.fib(input));
	}

	@Test
	public void testFibonacciInputNegative() {
		Fibonacci fibonacci = new Fibonacci();
		int input = -8;
		assertThrows(
				IllegalArgumentException.class,
				() -> {fibonacci.fib(input);}
		);
	}
}