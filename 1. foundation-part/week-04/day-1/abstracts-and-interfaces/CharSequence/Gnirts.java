package CharSequence;

import java.util.stream.IntStream;

public class Gnirts implements CharSequence {
	private String string;

	public Gnirts(String string) {
		this.string = new StringBuilder(string).reverse().toString();
	}

	@Override
	public int length() {
		return this.string.length();
	}

	@Override
	public char charAt(int index) {
		return this.string.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return this.string.subSequence(start, end);
	}

	@Override
	public IntStream chars() {
		return CharSequence.super.chars();
	}

	@Override
	public IntStream codePoints() {
		return CharSequence.super.codePoints();
	}
}
