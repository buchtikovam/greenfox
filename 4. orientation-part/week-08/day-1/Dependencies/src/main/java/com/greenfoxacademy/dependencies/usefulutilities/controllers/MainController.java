package com.greenfoxacademy.dependencies.usefulutilities.controllers;

import com.greenfoxacademy.dependencies.usefulutilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	private final UtilityService utilities;

	@Autowired
	public MainController(UtilityService utilities) {
		this.utilities = utilities;
	}

	@RequestMapping(
		value = "/useful",
		method = RequestMethod.GET
	)
	public String index() {
		return "index";
	}



	@RequestMapping(
		value = "/useful/colored",
		method = RequestMethod.GET
	)
	public String showColored(Model model) {

		model.addAttribute(
			"color",
			this.utilities.generateRandomColor()
		);
		return "randomBackground";
	}



	@RequestMapping(
		value = "/useful/email",
		method = RequestMethod.GET
	)
	public String emailValidation(
		@RequestParam(required = false) String email,
		Model model
	) {

		if (email != null) {
			model.addAttribute(
				"message",
				this.utilities.validateEmail(email)
			);

			model.addAttribute(
				"color",
				this.utilities.validationColor(email)
			);
		}

		return "email";
	}



	@RequestMapping(
		value = "/useful/caesar-encoder",
		method = RequestMethod.GET
	)
	public String showCaesarEncrypted() {
		return "index";
	}



	@RequestMapping(
		value = "/useful/caesar-decoder",
		method = RequestMethod.GET
	)
	public String showCaesarDecrypted() {
		return "index";
	}

}
