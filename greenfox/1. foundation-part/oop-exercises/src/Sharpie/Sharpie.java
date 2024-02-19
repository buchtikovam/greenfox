package Sharpie;

public class Sharpie {
	private String color;
	private int width;
	private int inkAmount = 100;

	public Sharpie(String color, int width) {
		this.color = color;
		this.width = width;
	}

	public void use() {
		inkAmount -= 10;
	}
}
