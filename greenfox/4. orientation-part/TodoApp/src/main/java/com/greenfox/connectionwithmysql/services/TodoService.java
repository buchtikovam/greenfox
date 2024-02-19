package com.greenfox.connectionwithmysql.services;

import com.greenfox.connectionwithmysql.models.Todo;
import java.util.List;

public interface TodoService {

	List<Todo> getAll();

	List<Todo> getActive();

	List<Todo> searchTask(String parameter);
}
