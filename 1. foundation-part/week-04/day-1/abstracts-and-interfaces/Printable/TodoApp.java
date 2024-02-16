package Printable;

import java.util.ArrayList;
import java.util.List;

public class TodoApp {
	private final List<Todo> listOfTodos = new ArrayList<>();

	public void addTodo(Todo todo) {
		this.listOfTodos.add(todo);
	}

	public void printAll() {
		for (Todo todo : listOfTodos) {
			todo.printAllFields();
		}
	}
}
