package com.greenfox.orientationtrialexam;

import com.greenfox.orientationtrialexam.models.Alias;
import com.greenfox.orientationtrialexam.models.Link;
import com.greenfox.orientationtrialexam.repositories.AliasRepository;
import com.greenfox.orientationtrialexam.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class OrientationTrialExamApplication
//	implements CommandLineRunner
{

//	private final LinkRepository linkRepository;
//	private final AliasRepository aliasRepository;
//
//	@Autowired
//	public OrientationTrialExamApplication(
//		LinkRepository linkRepository,
//		AliasRepository aliasRepository
//	) {
//		this.linkRepository = linkRepository;
//		this.aliasRepository = aliasRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(OrientationTrialExamApplication.class, args);
	}

//	@Override
//	public void run(String... args) {
//		Link link1 = new Link("https://youtube.com");
//		HashSet<Alias> aliases1 = new HashSet<>();
//		aliases1.add(new Alias("bye-bye-productivity"));
//		link1.setAliases(aliases1);
//		linkRepository.save(link1);
//
//		Link link2 = new Link("https://facebook.com");
//		HashSet<Alias> aliases2 = new HashSet<>();
//		aliases2.add(new Alias("howdy-friends"));
//		link2.setAliases(aliases2);
//		linkRepository.save(link2);
//
//		Link link3 = new Link("https://instagram.com");
//		HashSet<Alias> aliases3 = new HashSet<>();
//		aliases3.add(new Alias("adios-selflove"));
//		link3.setAliases(aliases3);
//		linkRepository.save(link3);
//	}
}
