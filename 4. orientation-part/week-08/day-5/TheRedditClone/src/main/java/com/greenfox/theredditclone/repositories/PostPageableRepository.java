package com.greenfox.theredditclone.repositories;

import com.greenfox.theredditclone.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostPageableRepository extends PagingAndSortingRepository<Post, Long> {

	List<Post> findPostById(Long id, Pageable pageable);



}
