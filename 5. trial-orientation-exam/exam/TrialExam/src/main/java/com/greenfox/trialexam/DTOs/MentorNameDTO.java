package com.greenfox.trialexam.DTOs;

import com.greenfox.trialexam.models.Mentor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MentorNameDTO {
	private String name;

	public MentorNameDTO(Mentor mentor) {
		this.name = mentor.getName();
	}
}

// just an empty box for keys and values, that needs to be filled by FE or BE