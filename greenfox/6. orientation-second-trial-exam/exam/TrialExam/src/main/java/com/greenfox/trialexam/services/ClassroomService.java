package com.greenfox.trialexam.services;

import com.greenfox.trialexam.models.Classroom;
import java.util.List;
import java.util.Optional;

public interface ClassroomService {

	Optional<Classroom> getClassroomByName(String name);

	Classroom save(Classroom classroom);

	List<Classroom> getAllByClassName(String className);

	List<Classroom> getAll();
}