package com.greenfox.orientationtrialexam.services;

import com.greenfox.orientationtrialexam.models.Alias;
import com.greenfox.orientationtrialexam.models.Link;
import com.greenfox.orientationtrialexam.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LinkServiceImpl implements LinkService {

	private final LinkRepository linkRepository;

	@Autowired
	public LinkServiceImpl(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}


	@Override
	public List<Link> getAllLinks() {
		return this.linkRepository.findAll();
	}


	@Override
	public void saveLinkAndAlias(Link link, Alias alias) {
		Set<Alias> aliasSet = new HashSet<>();
		aliasSet.add(alias);
		link.setAliases(aliasSet);
		this.linkRepository.save(link);
	}
}