package Fibonacci;

public class Fibonacci {
	public int fib(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Input must be greater than 1");
		}
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
