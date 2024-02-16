package com.greenfox.trialexam.services;

import com.greenfox.trialexam.models.Mentor;
import java.util.List;
import java.util.Optional;

public interface MentorService {

	List<Mentor> getAll();

	boolean checkIfMentorExists(String name);

	Optional<Mentor> findById(Long id);

	Mentor save(Mentor mentor);
}