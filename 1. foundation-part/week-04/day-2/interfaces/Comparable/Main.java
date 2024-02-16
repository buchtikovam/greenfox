package Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Domino> dominoes = new ArrayList<>();
		dominoes.add(new Domino(5, 2));
		dominoes.add(new Domino(4, 6));
		dominoes.add(new Domino(1, 5));
		dominoes.add(new Domino(6, 7));
		dominoes.add(new Domino(2, 4));
		dominoes.add(new Domino(7, 1));

		for (Domino domino: dominoes) {
			domino.printAllFields();
		}

		Collections.sort(dominoes);

		for (Domino domino: dominoes) {
			domino.printAllFields();
		}

		List<Todo> todos = new ArrayList<>();
		todos.add(new Todo("Complete assignment", "High", false));
		todos.add(new Todo("Buy groceries", "Medium", true));
		todos.add(new Todo("Read a book", "Low", false));
		todos.add(new Todo("Pay bills", "High", true));
		todos.add(new Todo("Exercise", "Medium", false));

		for (Todo todo: todos) {
			todo.printAllFields();
		}

		Collections.sort(todos);

		for (Todo todo: todos) {
			todo.printAllFields();
		}
	}
}