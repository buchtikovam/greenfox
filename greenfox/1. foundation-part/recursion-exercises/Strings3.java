import java.util.Objects;

public class Strings3 {
	// Given a string, write a recursive (no loops) method which returns a new
	// string with all adjacent chars separated by an `*`. Please note that there
	// should be no trailing `*` at the end of the returned string. For example,
	// the string `word` should be changed to `w*o*r*d`.
	public static void main(String[] args) {
		System.out.println(stringWithSymbols("hnihbub"));
	}

	public static String stringWithSymbols(String n) {
		if (n.length() <= 1) {
			return n;
		}

		String firstChar = String.valueOf(n.charAt(0));
		String symbol = "*";
		return (firstChar + symbol + stringWithSymbols(n.substring(1)));
	}
}