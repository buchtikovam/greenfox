package com.greenfox.connectionwithmysql.services;

import com.greenfox.connectionwithmysql.models.Assignee;
import com.greenfox.connectionwithmysql.repositories.AssigneeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AssigneeServiceImpl implements AssigneeService {

	private final AssigneeRepository assigneeRepository;

	public AssigneeServiceImpl(AssigneeRepository assigneeRepository) {
		this.assigneeRepository = assigneeRepository;
	}

	@Override
	public List<Assignee> getAll() {
		return assigneeRepository.findAll();
	}

	@Override
	public Optional<Assignee> showFirstById(Long id) {
		return assigneeRepository.findById(id);
	}

	@Override
	public void addOrUpdateAssignee(Assignee assignee) {
		assigneeRepository.save(assignee);
	}

	@Override
	public void removeById(Long id) {
		assigneeRepository.deleteById(id);
	}
}
