package com.greenfox.orientationtrialexam.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteAliasDTO {
	private String secretCode;

	public DeleteAliasDTO() {
	}

	public DeleteAliasDTO(
		String secretCode
	) {
		this.secretCode = secretCode;
	}
}