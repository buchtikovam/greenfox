package com.greenfox.connectionwithmysql.repositories;

import com.greenfox.connectionwithmysql.models.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssigneeRepository extends JpaRepository<Assignee, Long> {

	public Optional<Assignee> findById(Long id);

	public void deleteById(Long id);
}
