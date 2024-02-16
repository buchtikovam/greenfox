package com.greenfox.orientationtrialexam.services;

import com.greenfox.orientationtrialexam.models.Alias;
import com.greenfox.orientationtrialexam.models.Link;
import java.util.List;

public interface LinkService {

	List<Link> getAllLinks();

	void saveLinkAndAlias(Link link, Alias alias);
}
