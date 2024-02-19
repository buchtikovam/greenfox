package com.greenfox.trialexam.repositories;

import com.greenfox.trialexam.models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

	Optional<Mentor> findByName(String name);
}