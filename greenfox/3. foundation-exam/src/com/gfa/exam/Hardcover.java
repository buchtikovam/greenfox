package com.gfa.exam;

import com.gfa.exam.Book;

public class Hardcover extends Book {

	public Hardcover(String title, String author, int releaseYear, int numberOfPages) {
		super(title, author, releaseYear, numberOfPages);
		this.weight = this.numberOfPages * 10 + 100;
	}
}