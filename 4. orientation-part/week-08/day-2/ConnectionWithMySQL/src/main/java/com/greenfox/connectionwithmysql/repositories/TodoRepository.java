package com.greenfox.connectionwithmysql.repositories;

import com.greenfox.connectionwithmysql.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	List<Todo> findAllByDoneIsFalse();

	List<Todo> findAllByTitleContainsOrContentContainsOrDescriptionContains(
		String title, String content, String description
	);
}
