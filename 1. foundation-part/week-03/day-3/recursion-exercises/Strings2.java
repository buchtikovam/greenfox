public class Strings2 {
	public static void main(String[] args) {
		// Given a string, write a recursive (no loops) method which returns
		// a new string with the lowercase 'x' chars removed.
		System.out.println(removeXCharacters("xxxthxis couxxxrse isx grexxatxxx"));
	}

	public static String removeXCharacters(String n) {
		if (n.isEmpty()) {
			return "";
		}
		char firstChar = n.charAt(0);

		if (firstChar == 'x') {
			return removeXCharacters(n.substring(1));
		} else {
			return firstChar + removeXCharacters(n.substring(1));
		}
	}
}
