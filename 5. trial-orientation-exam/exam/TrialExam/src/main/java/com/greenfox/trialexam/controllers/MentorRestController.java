package com.greenfox.trialexam.controllers;

import com.greenfox.trialexam.DTOs.MentorNameDTO;
import com.greenfox.trialexam.DTOs.EditMentorDTO;
import com.greenfox.trialexam.models.Classroom;
import com.greenfox.trialexam.models.Mentor;
import com.greenfox.trialexam.services.ClassroomService;
import com.greenfox.trialexam.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class MentorRestController {

	private final MentorService mentorService;
	private final ClassroomService classroomService;

	@Autowired
	public MentorRestController(MentorService mentorService, ClassroomService classroomService) {
		this.mentorService = mentorService;
		this.classroomService = classroomService;
	}


	// show all mentor names, that match with given classroom
	@GetMapping("/mentors")
	public ResponseEntity showMentorByClass(
		@RequestParam String className
	) {
		Optional<Classroom> classroomOptional = this.classroomService.getClassroomByName(className);

		if (classroomOptional.isPresent()) {

			List<MentorNameDTO> mentorNameDTOList = new ArrayList<>();
			Set<Mentor> mentors = classroomOptional.get().getMentors();
			for (Mentor mentor : mentors) {
				mentorNameDTOList.add(new MentorNameDTO(mentor));
			}

			return ResponseEntity.status(200).body(mentorNameDTOList);
			// send the list of DTOs with OK status
		}

		return ResponseEntity.status(400).build();
	}



	// update mentor and classroom
	@PutMapping("/mentors/{id}")
	public ResponseEntity updateMentor(
		@PathVariable Long id,
		@RequestBody EditMentorDTO editMentorDTO
	) {
		Optional<Mentor> mentorOptional = this.mentorService.findById(id);

		// check if valid data was sent in body
		if (editMentorDTO.getClassName() == null) {
			return ResponseEntity.status(400).build();
		}

		// check if mentor was found by given id
		if (mentorOptional.isEmpty()) {
			return ResponseEntity.status(404).build();
		}

		Mentor mentor = mentorOptional.get();

		// set new values based on DTO, setting classroom through mentor, saving only mentor
		mentor.setName(editMentorDTO.getName());
		mentor.setClassroom(
			this.classroomService.getClassroomByName(
				editMentorDTO.getClassName()
			).get()
		);

		this.mentorService.save(mentor);
		return ResponseEntity.status(200).build();
	}
}