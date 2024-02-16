package com.greenfox.theredditclone.services;

import com.greenfox.theredditclone.models.Post;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PostService {
	List<Post> getAll();

	Optional<Post> getPostById(Long id);

	void addOrUpdate(Post post);

	Page<Post> getPagedPosts(Integer pageNo, Integer pageSize, String sortBy);
}
