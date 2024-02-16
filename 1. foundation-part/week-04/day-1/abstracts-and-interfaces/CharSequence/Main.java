package CharSequence;

import java.lang.CharSequence;

public class Main {
	public static void main(String[] args) {
		Gnirts gnirts = new Gnirts("example");
		System.out.println(gnirts.charAt(1));
		ShiftedCharSequence shifter = new ShiftedCharSequence("example", 2);
		System.out.println(shifter.charAt(0));
	}
}
