package Zoo;

public abstract class Animal {
	private String name;
	private int age;
	private String gender;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public abstract String breed();

	public void poop() {
		System.out.println("is pooping");
	}
}
