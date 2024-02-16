package com.gfa.exam;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bookshelf {

	protected int capacity;
	protected HashSet<Book> books;
	protected int currentNumberOfBooks;

	public Bookshelf(int capacity) {
		this.capacity = capacity;
		this.currentNumberOfBooks = 0;
		this.books = new HashSet<>();
	}

	public void addBook(Book book) {
		if (currentNumberOfBooks >= capacity) {
			throw new RuntimeException("Bookshelf is already full!");
		}

		this.books.add(book);
		currentNumberOfBooks++;
	}

	public Map<String, String> getBooks(int year) {
		HashMap<String, String> booksByYear = new HashMap<>();

		for (Book book : this.books) {
			if (book.releaseYear == year) {
				booksByYear.put(book.title, book.author);
			}
		}

		return booksByYear;
	}

	public String getLightestAuthor() {
		int lightestNumber = 1000000;
		String lightestAuthor = "";

		for (Book book : this.books) {

			if (book.weight < lightestNumber) {
				lightestNumber = book.weight;
				lightestAuthor = book.author;
			}
		}

		return lightestAuthor;
	}

	public void printBooks() {
		for (Book book : this.books) {
			System.out.println(book.getBookInfo());
		}
	}

	public String getMaxAuthor() {
		HashMap<String, Integer> writtenPages = new HashMap<>();
		String maxAuthor = "";

		for (Book book : this.books) {
			System.out.println(book.getBookInfo());

			if (!writtenPages.containsKey(book.author)) {
				writtenPages.put(book.author, book.numberOfPages);

			} else {
				writtenPages.put(
					book.author,
					writtenPages.get(book.author) + book.numberOfPages
				);
			}
		}

		return Collections.max(writtenPages.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}