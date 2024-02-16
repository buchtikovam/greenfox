package com.greenfox.orientationtrialexam.repositories;

import com.greenfox.orientationtrialexam.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
