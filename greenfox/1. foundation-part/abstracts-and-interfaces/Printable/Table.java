package Printable;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private final List<Domino> listOfDominos = new ArrayList<>();

	public void addDomino(Domino domino) {
		this.listOfDominos.add(domino);
	}

	public void printAll() {
		for (Domino domino : listOfDominos) {
			domino.printAllFields();
		}
	}
}
