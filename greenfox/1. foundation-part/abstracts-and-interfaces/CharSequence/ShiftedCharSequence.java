package CharSequence;

import java.util.stream.IntStream;

public class ShiftedCharSequence implements CharSequence {
	private String string;
	private int number;

	public ShiftedCharSequence(String string, int number) {
		this.string = string;
		this.number = number;
	}

	@Override
	public int length() {
		return this.string.length();
	}

	@Override
	public char charAt(int index) {
		return this.string.charAt(index + this.number);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return this.string.subSequence(
			start + this.number,
			end + this.number
		);
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
