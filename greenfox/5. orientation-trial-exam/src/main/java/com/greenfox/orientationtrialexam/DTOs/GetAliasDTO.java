package com.greenfox.orientationtrialexam.DTOs;

import com.greenfox.orientationtrialexam.models.Alias;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetAliasDTO {
	private Long id;
	private String url;
	private String alias;
	private int hitCount;

	public GetAliasDTO(
		Alias alias
	) {
		this.id = alias.getId();
		this.url = alias.getLink().getUrl();
		this.alias = alias.getAlias();
		this.hitCount = alias.getHitCount();
	}
}