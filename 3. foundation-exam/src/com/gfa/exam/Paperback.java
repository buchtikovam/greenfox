package com.gfa.exam;

import com.gfa.exam.Book;

public class Paperback extends Book {

	public Paperback(String title, String author, int releaseYear, int numberOfPages) {
		super(title, author, releaseYear, numberOfPages);
		this.weight = numberOfPages * 10 + 20;
	}
}