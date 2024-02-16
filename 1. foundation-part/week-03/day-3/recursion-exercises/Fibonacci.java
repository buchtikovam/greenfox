public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(
			fibonacci(12)
		);
	}

	public static int fibonacci(int position)  {
		if (position < 2) return position;
		return fibonacci(position - 1) + fibonacci(position - 2);
	}
}
