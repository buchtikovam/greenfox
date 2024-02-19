public class Person {
	protected String name = "Jane Doe";
	protected int age = 30;
	protected String gender = "female";

	public Person() {
	}

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void getGoal() {
		System.out.println("My goal is: Live for the moment!");
	}

	public void introduce() {
		System.out.println("Hi, I'm "
			+ this.name
			+ " a "
			+ this.age
			+ " year old "
			+ this.gender
			+ "."
		);
	}
}
