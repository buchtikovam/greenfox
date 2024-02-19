package com.greenfox.trialexam.repositories;

import com.greenfox.trialexam.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

	Optional<Classroom> findByClassName(String classname);

	List<Classroom> findAllByClassName(String className);
}