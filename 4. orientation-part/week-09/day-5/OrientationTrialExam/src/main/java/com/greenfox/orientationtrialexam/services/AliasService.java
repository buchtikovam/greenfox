package com.greenfox.orientationtrialexam.services;

import com.greenfox.orientationtrialexam.models.Alias;
import java.util.List;
import java.util.Optional;

public interface AliasService {

	List<Alias> getAllAliases();

	boolean checkIfAliasExistsInDatabase(String alias);

	String decideReaction(String reaction, Long aliasId);

	String decideColorByReaction(String reaction);

	Optional<Alias> findByAlias(String alias);

	Optional<Alias> findById(Long id);

	void save(Alias alias);

	void delete(Alias alias);
}