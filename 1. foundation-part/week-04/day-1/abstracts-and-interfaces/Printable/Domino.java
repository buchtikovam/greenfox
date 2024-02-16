package Printable;

public class Domino implements Printable {
	private final int leftSide;
	private final int rightSide;

	public Domino(int leftSide, int rightSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}

	public int getLeftSide() {
		return leftSide;
	}

	public int getRightSide() {
		return rightSide;
	}

	@Override
	public void printAllFields() {
		System.out.println(this.getClass().getSimpleName()
			+ " A side: "
			+ getLeftSide()
			+ ", B side: "
			+ getRightSide());
	}
}
