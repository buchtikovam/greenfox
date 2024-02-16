public class Power {
	public static void main(String[] args) {
		System.out.println(calculatePower(3, 3));
	}
	public static int calculatePower(int base, int n) {
		if (n == 0) {
			return 1;
		} else {
			return base * calculatePower(base, n - 1);
		}
	}
}
