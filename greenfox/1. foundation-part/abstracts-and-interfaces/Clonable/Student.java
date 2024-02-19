package Clonable;

final public class Student extends Person {
	private String previousOrganization = "The School of Life";
	public int skippedDays = 0;

	public Student(
		String name,
		int age,
		String gender,
		String previousOrganization
	) {
		super(name, age, gender);
		this.previousOrganization = previousOrganization;
	}

	public Student() {
		super();
	}

	@Override
	public void getGoal() {
		System.out.println("Be a junior software developer.");
	}

	@Override
	public void introduce() {
		System.out.println(
			"Hi, I'm "
			+ this.name
			+ " a "
			+ this.age
			+ " year old "
			+ this.gender
			+ " from "
			+ this.previousOrganization
			+ " who skipped "
			+ this.skippedDays
			+ " days from the course already."
		);
	}

	public void skipDays(int numberOfDays) {
		this.skippedDays += numberOfDays;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
