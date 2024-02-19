public class Strings {
	public static void main(String[] args) {
		// Given a string, write a recursive (no loops) method which returns
		// a new string with the lowercase 'x' chars changed to 'y' chars.
		System.out.println(changeXtoY("xxx hello xxx"));
	}
	public static String changeXtoY(String n) {
		if (n.isEmpty()) {
			return "";
		}

		char firstChar = n.charAt(0);
		char newChar = 'y';

		if (firstChar == 'x') {
			return newChar + changeXtoY(n.substring(1));
		} else {
			return firstChar + changeXtoY(n.substring(1));
		}
	}
}
