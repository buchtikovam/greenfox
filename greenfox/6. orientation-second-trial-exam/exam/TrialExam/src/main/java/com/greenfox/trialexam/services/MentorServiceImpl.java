package com.greenfox.trialexam.services;

import com.greenfox.trialexam.models.Mentor;
import com.greenfox.trialexam.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {

	private final MentorRepository mentorRepository;

	@Autowired
	public MentorServiceImpl(MentorRepository mentorRepository) {
		this.mentorRepository = mentorRepository;
	}

	@Override
	public List<Mentor> getAll() {
		return this.mentorRepository.findAll();
	}

	@Override
	public boolean checkIfMentorExists(String name) {
		return this.mentorRepository.findByName(name).isPresent();
	}

	@Override
	public Optional<Mentor> findById(Long id) {
		return this.mentorRepository.findById(id);
	}

	@Override
	public Mentor save(Mentor mentor) {
		return this.mentorRepository.save(mentor);
	}
}