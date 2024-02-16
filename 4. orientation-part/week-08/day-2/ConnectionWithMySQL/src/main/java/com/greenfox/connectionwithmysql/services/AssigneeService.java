package com.greenfox.connectionwithmysql.services;

import com.greenfox.connectionwithmysql.models.Assignee;
import java.util.List;
import java.util.Optional;


public interface AssigneeService {

	List<Assignee> getAll();

	Optional<Assignee> showFirstById(Long id);

	void addOrUpdateAssignee(Assignee assignee);

	void removeById(Long id);
}
