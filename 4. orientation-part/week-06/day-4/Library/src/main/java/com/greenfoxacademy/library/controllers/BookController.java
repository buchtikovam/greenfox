package com.greenfoxacademy.library.controllers;

import com.greenfoxacademy.library.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//	GET index / = www.google.com/api/v0/books/
//	GET show /123 = www.google.com/api/v0/books/123
//	POST store / = www.google.com/api/v0/books/
//	DELETE delete / = www.google.com/api/v0/books/
//	PUT update / = www.google.com/api/v0/books/
//	PATCH update / = www.google.com/api/v0/books/

@Controller
public class BookController
{
	private final List<Book> books = new ArrayList<>();

	public BookController() {
		books.add(
			new Book(
				"Cat's Cradle",
				"Kurt Vonnegut",
				1963
			)
		);
		books.add(
			new Book(
				"Do Androids Dream of Electric Sheep?",
				"Philip K. Dick",
				1968
			)
		);
	}



	// List all books
	@RequestMapping(
		path = "/books",
		method = RequestMethod.GET
	)
	public String index(
		Model model,
		@RequestParam(name = "author", required = false) String author
	) {
		List<Book> filteredBooks = books;

		if (author != null) {
			filteredBooks = books.stream()
				.filter(book -> book.getAuthor().equals(author))
				.collect(Collectors.toList());
		}

		model.addAttribute("books", filteredBooks);
		return "index";
	}



	// Show one book
	@RequestMapping(
		path = "/books/{id}",
		method = RequestMethod.GET
	)
	public String show(
		Model model,
		@PathVariable(name="id") Integer id
	) {
		for(Book book : books) {
			if (book.getId() == id) {
				model.addAttribute("book", book);
				return "show";
			}
		}

		model.addAttribute("error", "No book found");
		return "show";
	}



	// HTML Form
	@RequestMapping(
		path = "/books/add",
		method = RequestMethod.GET
	)
	public String showAddBookForm(
		Model model,
		@ModelAttribute(name="book") Book book
	) {
		model.addAttribute("book", book);
		return "add";
	}



	// Store book
	@RequestMapping(
		path = "/books",
		method = RequestMethod.POST
	)
	public String store(
		@ModelAttribute(name="book") Book book
	) {
		books.add(book);
		return "redirect:/books";
	}
}