package com.greenfoxacademy.bankofsimba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HTMLceptionController {

	@RequestMapping(
		value = "/ception",
		method = RequestMethod.GET
	)
	public String getString(Model model) {
		model.addAttribute(
			"sentence",
			"This is an <em>HTML</em> text. <b>Enjoy yourself!</b>"
		);
		return "ception";
	}
}
