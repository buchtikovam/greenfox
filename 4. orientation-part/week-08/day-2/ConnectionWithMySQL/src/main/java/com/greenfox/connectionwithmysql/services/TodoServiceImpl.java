package com.greenfox.connectionwithmysql.services;

import com.greenfox.connectionwithmysql.models.Todo;
import com.greenfox.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;

	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public List<Todo> getAll() {
		return todoRepository.findAll();
	}

	@Override
	public List<Todo> getActive() {
		return todoRepository.findAllByDoneIsFalse();
	}

	@Override
	public List<Todo> searchTask(String parameter) {
		return todoRepository.findAllByTitleContainsOrContentContainsOrDescriptionContains(
			parameter, parameter, parameter
		);
	}
}
