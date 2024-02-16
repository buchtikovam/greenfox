package com.greenfox.trialexam.controllers;

import com.greenfox.trialexam.models.Classroom;
import com.greenfox.trialexam.models.Mentor;
import com.greenfox.trialexam.services.ClassroomService;
import com.greenfox.trialexam.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class MentorController {

	private final MentorService mentorService;
	private final ClassroomService classroomService;

	@Autowired
	public MentorController(MentorService mentorService, ClassroomService classroomService) {
		this.mentorService = mentorService;
		this.classroomService = classroomService;
	}


	// show main page, sending both mentors and classrooms (for dropdown menu)
	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute(
			"mentors",
			this.mentorService.getAll()
		);

		model.addAttribute(
			"classrooms",
			this.classroomService.getAll()
		);

		return "index";
	}



	// Adding a new mentor to database, if it doesn't have a class already
	@PostMapping("/mentor")
	public String addMentor(
		@RequestParam String name,
		@RequestParam String classroom,
		Model model
	) {
		// sending error through model, because not using redirect
		if (this.mentorService.checkIfMentorExists(name)) {
			model.addAttribute(
				"error",
				"Mentor already has his classroom. Please choose someone else"
			);
			return "error";
		}

		Optional<Classroom> classroomOptional = this.classroomService.getClassroomByName(classroom);

		Classroom classroom1 = classroomOptional.get();
		Mentor mentor = new Mentor(name);
		mentor.setClassroom(classroom1);
		this.mentorService.save(mentor);
		return "redirect:/mentor/" + mentor.getId();
	} // classroom was getting duplicated
	  // because i was creating a new classroom with the value of dropdown item



	// Showing mentor detail page
	@GetMapping("/mentor/{id}")
	public String details(
		@PathVariable Long id,
		Model model
	) {
		Optional<Mentor> mentorOptional = this.mentorService.findById(id);

		// Validating if id corresponds to mentor
		if (mentorOptional.isPresent()) {
			Mentor mentor = mentorOptional.get();

			model.addAttribute(
				"name",
				"<b>Name:</b> " + mentor.getName()
			);
			model.addAttribute(
				"classroomName",
				"<b>Class:</b> " + mentor.getClassroom().getClassName()
			);

			return "detail";
		}

		model.addAttribute(
			"error",
			"Mentor was not found"
		);

		return "error";
	}
}