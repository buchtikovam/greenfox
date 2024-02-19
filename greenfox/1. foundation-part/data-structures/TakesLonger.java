public class TakesLonger {
	public static void main(String... args) {
		String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

		// When saving this quote a disk error has occurred. Please fix it!
		// Insert the words "always takes longer than" between the words "It" and "you" using the StringBuilder class!
		String fixedQuote = quote.substring(0, 21) + "always takes longer than" + quote.substring(20);
		System.out.println(fixedQuote);
	}
}