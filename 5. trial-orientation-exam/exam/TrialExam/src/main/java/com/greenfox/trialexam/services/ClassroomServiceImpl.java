package com.greenfox.trialexam.services;

import com.greenfox.trialexam.models.Classroom;
import com.greenfox.trialexam.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

	private final ClassroomRepository classroomRepository;

	@Autowired
	public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
		this.classroomRepository = classroomRepository;
	}


	@Override
	public Optional<Classroom> getClassroomByName(String name) {
		return this.classroomRepository.findByClassName(name);
	}

	@Override
	public Classroom save(Classroom classroom) {
		return this.classroomRepository.save(classroom);
	}

	@Override
	public List<Classroom> getAllByClassName(String className) {
		return this.classroomRepository.findAllByClassName(className);
	}

	@Override
	public List<Classroom> getAll() {
		return this.classroomRepository.findAll();
	}
}