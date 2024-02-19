final public class Sponsor extends Person {
	public String company = "Google";
	public int hiredStudents = 0;

	public Sponsor(
		String name,
		int age,
		String gender,
		String company
	) {
		super(name, age, gender);
		this.company = company;
	}

	public Sponsor() {
		super();
	}

	@Override
	public void getGoal() {
		System.out.println(
			"Hire brilliant junior software developers."
		);
	}

	@Override
	public void introduce() {
		System.out.println("Hi, I'm "
			+ this.name
			+ " a "
			+ this.age
			+ " year old "
			+ this.gender
			+ " who represents "
			+ this.company
			+ " and hired "
			+ hiredStudents
			+ " so far."
		);
	}

	public void hire() {
		this.hiredStudents++;
	}
}
