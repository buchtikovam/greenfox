package com.greenfox.connectionwithmysql.controllers;

import com.greenfox.connectionwithmysql.models.Assignee;
import com.greenfox.connectionwithmysql.services.AssigneeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AssigneeController {

	private final AssigneeService assigneeService;

	public AssigneeController(AssigneeService assigneeService) {
		this.assigneeService = assigneeService;
	}


	// show all assignees
	@RequestMapping(
		value = "/show-assignees",
		method = RequestMethod.GET
	)
	public String listAssignees(Model model) {
		model.addAttribute(
			"assignees",
			this.assigneeService.getAll()
		);
		return "assignee";
	}



	// getting edit page
	@RequestMapping(value = "/edit-assignee/{uncheckedId}", method = RequestMethod.GET)
	public String editAssignee(Model model, @PathVariable String uncheckedId) {
		// checking if id is valid
		Long id;
		try {
			id = Long.parseLong(uncheckedId);
		} catch(NumberFormatException e) {
			model.addAttribute("error", "id must contain numbers only");
			return "error";
		}

		Optional<Assignee> foundAssignee = this.assigneeService.showFirstById(id);

		if (foundAssignee.isPresent()) {
			model.addAttribute("assignee", foundAssignee.get());
			return "edit-assignee";
		}
		return "redirect:/";
	}



	// updating assignee in the database
	@RequestMapping(
		value = "/update-assignee/{id}",
		method = RequestMethod.POST
	)
	public String updateAssignee(
		@PathVariable String id,
		@ModelAttribute Assignee assignee
	) {
		Optional<Assignee> foundAssignee = this.assigneeService.showFirstById(Long.valueOf(id));

		if (foundAssignee.isPresent()) {
			Assignee oldAssignee = foundAssignee.get();
			oldAssignee.setName(assignee.getName());
			oldAssignee.setEmail(assignee.getEmail());
			this.assigneeService.addOrUpdateAssignee(oldAssignee);
		}

		return "redirect:/show-assignees";
	}



	// adding a new assignee to the database
	@RequestMapping(
		value = "/add-assignee",
		method = RequestMethod.POST
	)
	public String addAssignee(
		@ModelAttribute Assignee assignee
	) {
		if (assignee.getEmail().contains("@") &&
				assignee.getEmail().contains("."))
		{
			Assignee newAssignee = new Assignee(assignee.getName(), assignee.getEmail());
			this.assigneeService.addOrUpdateAssignee(newAssignee);
		}

		return "redirect:/show-assignees";
	}



	// getting confirm remove page
	@RequestMapping(value = "/remove-assignee/{id}", method = RequestMethod.GET)
	public String removeAssignee(Model model, @PathVariable String id) {
		try {
			Long id2 = Long.parseLong(id);
		} catch(NumberFormatException e) {
			model.addAttribute("error", "id must contain numbers only");
			return "error";
		}

		Optional<Assignee> foundAssignee = this.assigneeService.showFirstById(Long.valueOf(id));
		if (foundAssignee.isPresent()) {
			model.addAttribute("assignee", foundAssignee.get());
			return "remove-assignee";
		}
		return "redirect:/show-assignee";
	}



	// removing assignee from the database
	@RequestMapping(value = "/remove-assignee/{id}", method = RequestMethod.POST)
	public String removeAssignee(@PathVariable String id) {
		this.assigneeService.removeById(Long.parseLong(id));
		return "redirect:/show-assignees";
	}
}