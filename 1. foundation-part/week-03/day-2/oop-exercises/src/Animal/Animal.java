package Animal;

public class Animal {
	private int hunger = 50;
	private int thirst = 50;

	public Animal() {
	}

	public void eat() {
		this.hunger --;
	}
	public void drink() {
		this.thirst --;
	}

	public void play() {
		this.thirst ++;
		this.hunger ++;
	}
}
