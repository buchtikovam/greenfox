package com.greenfox.theredditclone.controllers;

import com.greenfox.theredditclone.models.Post;
import com.greenfox.theredditclone.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

	private final PostService postService;

	@Autowired
	public MainController(PostService postService) {
		this.postService = postService;
	}


	@GetMapping
	public String index(
		@RequestParam(defaultValue = "0") Integer pageNo,
		@RequestParam(defaultValue = "10") Integer pageSize,
		@RequestParam(defaultValue = "votes") String sortBy,
		Model model
	) {
		Page<Post> posts = this.postService.getPagedPosts(pageNo, pageSize, sortBy);

		model.addAttribute("posts", posts.getContent());
		model.addAttribute("totalPages", posts.getTotalPages());
		model.addAttribute("previousPage", pageNo - 1);
		model.addAttribute("nextPage", pageNo + 1);
		return "index";
	}



	// Show page for submitting a new post
	@GetMapping(value = "/submit-new")
	public String showNewPostForm() {
		return "new-post";
	}



	// Add a new post to database
	@PostMapping(value = "/add-new")
	public String submitPost(
		@RequestParam String title,
		@RequestParam String url,
		Model model
	) {
		if (! url.contains(".")) {
			model.addAttribute("error", "Please provide a valid url");
			return "new-post";
		} else {
			this.postService.addOrUpdate(new Post(title, url));
		}

		return "redirect:/";
	}



	@GetMapping(value = "/posts/{_id}/upvote")
	public String upvote(
		@PathVariable String _id
	) {
		Long id = Long.parseLong(_id);
		Optional<Post> optionalPost = this.postService.getPostById(id);
		if (optionalPost.isPresent()) {
			Post post = optionalPost.get();
			post.setVotes(post.getVotes() + 1);
			this.postService.addOrUpdate(post);
			return "redirect:/";
		}

		return "redirect:/";
	}



	@GetMapping(value = "/posts/{_id}/downvote")
	public String downvote(
		@PathVariable String _id
	) {
		Long id = Long.parseLong(_id);
		Optional<Post> optionalPost = this.postService.getPostById(id);
		if (optionalPost.isPresent()) {
			Post post = optionalPost.get();
			post.setVotes(post.getVotes() - 1);
			this.postService.addOrUpdate(post);
			return "redirect:/";
		}

		return "redirect:/";
	}
}
