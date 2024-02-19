public class SecondsInADay {
	public static void main(String[] args) {
		// Write a program that prints the remaining seconds (as an integer) from a
		// day if the current time is represented by the variables above
		int secondsPassed = (14 * 3600) + (34 * 60) + 42;
		int secondsInDay = 24 * 3600;
		System.out.println(secondsInDay - secondsPassed);
	}
}
