package Counter;
public class Counter {
	private int initialValue = 0;
	private int counter = initialValue;

	public Counter() {
	}

	public Counter(int counter) {
		this.counter = counter;
		this.initialValue = counter;
	}

	// methods
	public void add() {
		counter++;
	}
	public void add(int number) {
		this.counter += number;
	}

	public int get(){
		return counter;
	}

	public int reset() {
		this.counter = initialValue;
		return counter;
	}
}

