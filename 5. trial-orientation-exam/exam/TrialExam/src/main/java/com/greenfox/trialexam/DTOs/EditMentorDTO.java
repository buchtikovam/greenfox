package com.greenfox.trialexam.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditMentorDTO {
	private String name;
	private String className;

	public EditMentorDTO(String name, String className) {
		this.name = name;
		this.className = className;
	}

	// just an empty box for keys and values, that needs to be filled by FE or BE
}