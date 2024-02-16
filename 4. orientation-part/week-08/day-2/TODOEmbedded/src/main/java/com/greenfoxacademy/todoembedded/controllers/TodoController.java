package com.greenfoxacademy.todoembedded.controllers;

import com.greenfoxacademy.todoembedded.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

	private final TodoRepository todoRepository;

	@Autowired
	public TodoController(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@RequestMapping(value = {"/", "/list"})
	public String list(Model model) {
		model.addAttribute("todos", this.todoRepository.findAll());
		return "index";
	}
}

