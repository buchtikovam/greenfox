package com.greenfox.connectionwithmysql.controllers;

import com.greenfox.connectionwithmysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

	private final TodoService todoService;

	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}


	// show all todos
	@RequestMapping(
		value = "/",
		method = RequestMethod.GET
	)
	public String list(Model model) {

		model.addAttribute(
			"todos",
			this.todoService.getAll()
		);

		return "index";
	}



	// show uncompleted tasks
	@RequestMapping(
		value = "/show-active",
		method = RequestMethod.GET
	)
	public String showActive(Model model) {

		model.addAttribute(
			"todos",
			this.todoService.getActive()
		);

		return "index";
	}



	// search through form
	@RequestMapping(
		value = "/search",
		method = RequestMethod.POST
	)
	public String searchBy(
		Model model,
		@RequestParam String parameter
	) {

		model.addAttribute(
			"todos",
			this.todoService.searchTask(parameter)
		);

		return "index";
	}
}