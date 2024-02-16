package com.greenfox.theredditclone.services;

import com.greenfox.theredditclone.models.Post;
import com.greenfox.theredditclone.repositories.PostPageableRepository;
import com.greenfox.theredditclone.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;
	private final PostPageableRepository postPageableRepository;

	@Autowired
	public PostServiceImpl(PostRepository postRepository, PostPageableRepository postPageableRepository) {
		this.postRepository = postRepository;
		this.postPageableRepository = postPageableRepository;
	}

	@Override
	public List<Post> getAll() {
		return this.postRepository.findAll();
	}

	@Override
	public Optional<Post> getPostById(Long id) {
		return this.postRepository.getPostById(id);
	}

	@Override
	public void addOrUpdate(Post post) {
		this.postRepository.save(post);
	}

	@Override
	public Page<Post> getPagedPosts(Integer pageNo, Integer pageSize, String sortBy) {
		return postRepository.findAll(
			PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending())
		);
	}

}
