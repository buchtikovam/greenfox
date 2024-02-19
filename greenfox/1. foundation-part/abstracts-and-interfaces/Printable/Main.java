package Printable;

public class Main {
	public static void main(String[] args) {
		Table table = new Table();
		TodoApp app = new TodoApp();

		table.addDomino(new Domino(2, 3));
		table.addDomino(new Domino(4, 6));
		table.addDomino(new Domino(6, 1));

		app.addTodo(new Todo(
			"Get milk",
			"high",
			false
		));

		app.addTodo(new Todo(
			"Eat lunch",
			"low",
			true
		));

		app.addTodo(new Todo(
			"Smile",
			"middle",
			true
		));

		table.printAll();
		System.out.println();
		app.printAll();
	}
}
