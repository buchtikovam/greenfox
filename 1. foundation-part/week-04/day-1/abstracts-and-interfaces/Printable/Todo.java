package Printable;

public class Todo implements Printable {
	private final String task;
	private final String priority;
	private final boolean isDone;

	public Todo(String task, String priority, boolean isDone) {
		this.task = task;
		this.priority = priority;
		this.isDone = isDone;
	}

	@Override
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
}
