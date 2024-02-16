import java.util.ArrayList;
import java.util.List;

final public class Cohort {
	public String name;
	public List<Student> students = new ArrayList<>();
	public List<Mentor> mentors = new ArrayList<>();

	public Cohort(String name) {
		this.name = name;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void addMentor(Mentor mentor) {
		mentors.add(mentor);
	}

	public void info() {
		System.out.println("The "
		+ this.name
		+ " cohort has "
		+ students.size()
		+ " students and "
		+ mentors.size()
		+ " mentors."
		);
	}
}
