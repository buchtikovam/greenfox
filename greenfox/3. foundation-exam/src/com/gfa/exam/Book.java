package com.gfa.exam;

public abstract class Book {
	protected String title;
	protected String author;
	protected int releaseYear;
	protected int numberOfPages;
	protected int weight;

	public Book(
		String title,
		String author,
		int releaseYear,
		int numberOfPages
	) {
		this.title = title;
		this.author = author;
		this.releaseYear = releaseYear;
		this.numberOfPages = numberOfPages;
	}

	public void setWeight(int number) {
		this.weight = number;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public int getWeight() {
		return weight;
	}

	public String getBookInfo() {
		return
			this.author
			+ ": "
			+ this.title
			+ " ("
			+ this.releaseYear
			+ ")";
	}
}
