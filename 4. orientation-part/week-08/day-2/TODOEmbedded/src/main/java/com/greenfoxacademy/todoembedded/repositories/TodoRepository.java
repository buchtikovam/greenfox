package com.greenfoxacademy.todoembedded.repositories;

import com.greenfoxacademy.todoembedded.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
