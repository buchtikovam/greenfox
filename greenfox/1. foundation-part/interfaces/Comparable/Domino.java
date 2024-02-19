package Comparable;

public class Domino implements Comparable<Domino> {
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

	public void printAllFields() {
		System.out.println(this.getClass().getSimpleName()
			+ " A side: "
			+ getLeftSide()
			+ ", B side: "
			+ getRightSide());
	}

	@Override
	public int compareTo(Domino d2) {
		return Integer.compare(this.leftSide, d2.leftSide);
	}
}