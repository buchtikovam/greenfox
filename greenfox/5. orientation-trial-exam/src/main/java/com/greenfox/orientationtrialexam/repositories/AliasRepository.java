package com.greenfox.orientationtrialexam.repositories;

import com.greenfox.orientationtrialexam.models.Alias;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AliasRepository extends JpaRepository<Alias, Long> {

	Optional<Alias> findByAlias(String alias);
}