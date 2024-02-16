package com.greenfox.theredditclone;

import com.greenfox.theredditclone.models.Post;
import com.greenfox.theredditclone.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheRedditCloneApplication {

	private final PostRepository postRepository;

	@Autowired
	public TheRedditCloneApplication(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TheRedditCloneApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		this.postRepository.save(new Post(
//				"This scared the handstand out of him!",
//				"https://www.tiktok.com/@localvidplug/video/7298061725218180384?_r=1&_t=8hE2OsxPgLx"
//		));
//		this.postRepository.save(new Post(
//				"Famous last words...",
//				"https://www.tiktok.com/@funny.girl69.us/video/7289103154799529249?_r=1&_t=8hFD6DIpbNI"
//		));
//		this.postRepository.save(new Post(
//				"Police searches home of wanted criminal",
//				"https://www.tiktok.com/@pickmeups_/video/7291745736574733614?_r=1&_t=8hFD9V7LeFs"
//		));
//		this.postRepository.save(new Post(
//				"You can tell he loves bubbles",
//				"https://www.tiktok.com/@madadillo/video/7295549628504722731?_r=1&_t=8hFD86CQzAH"
//		));
//		this.postRepository.save(new Post(
//				"Thieves caught committing a crime!",
//				"https://www.tiktok.com/@paulscanlonuk/video/7298664481389923616?_r=1&_t=8hFDBpcsvi4"
//		));
//		this.postRepository.save(new Post(
//				"Just a seagull getting groceries",
//				"https://www.tiktok.com/@laughhard__/video/7283527754249833774?_r=1&_t=8hFDDG8shOL"
//		));
//		this.postRepository.save(new Post(
//				"Someone's getting way too exited...",
//				"https://www.tiktok.com/@forsmiles_/video/7275414666543746337?_r=1&_t=8hFDDXkIm5w"
//		));
//		this.postRepository.save(new Post(
//				"When the weekend finally hits...",
//				"https://www.tiktok.com/@nimbus_siberian/video/7289474970575555883?_r=1&_t=8hFDEvMxDdI"
//		));
//		this.postRepository.save(new Post(
//				"I bet he thinks he is the main character!",
//				"https://www.tiktok.com/@funnyshit042/video/7280998802029333793?_r=1&_t=8hFDB6nzLXc"
//		));
//		this.postRepository.save(new Post(
//				"Just a bear enjoying hiw swing set",
//				"https://www.tiktok.com/@pubity/video/7296501848075242785?_r=1&_t=8hFDE8oO036"
//		));
//		this.postRepository.save(new Post(
//				"Cat scares seagull",
//				"https://www.tiktok.com/@memefunny306/video/7278687813720116512?_r=1&_t=8hFDEycRbEW"
//		));
//		this.postRepository.save(new Post(
//				"Dog is very unhappy about his dinner being late",
//				"https://www.tiktok.com/@chillithegreyhound/video/7280854563677146370?_r=1&_t=8hFDEycRbEW"
//		));
//		this.postRepository.save(new Post(
//				"Raccon gets dizzy after 3 spins and falls",
//				"https://www.tiktok.com/@plutosdestiny/video/7298640303370571040?_r=1&_t=8hFDGNGw0Dh"
//				));
//		this.postRepository.save(new Post(
//				"A man got his army of turkeys",
//				"https://www.tiktok.com/@duyen123us1/video/7299255122805132576?_t=8hFDH3UeFG4&_r=1"
//		));
//		this.postRepository.save(new Post(
//				"Snail hitchhiker",
//				"https://www.tiktok.com/@atticusareola/video/7295325083982204192?_r=1&_t=8hFDFkAZgYr"
//		));
//		this.postRepository.save(new Post(
//				"Oh dear",
//				"https://www.tiktok.com/@localvidplug/video/7274678770856922400?_r=1&_t=8hFDItlKHxZ"
//		));
//	}
}
