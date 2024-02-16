package Comparable;

public class Todo implements Comparable<Todo> {
	private final String task;
	private final String priority;
	private final boolean isDone;

	public Todo(String task, String priority, boolean isDone) {
		this.task = task;
		this.priority = priority;
		this.isDone = isDone;
	}

	public void printAllFields() {
		System.out.println(
			"Task: "
			+ this.task
			+ " | Priority: "
			+ this.priority
			+ " | Done: "
			+ this.isDone
		);
	}

	@Override
	public int compareTo(Todo t2) {
		int doneComparison = Boolean.compare(this.isDone, t2.isDone);
		if (doneComparison != 0) {
			return doneComparison;
		}
		return this.task.compareTo(t2.task);
	}
}
