package com.greenfox.orientationtrialexam.services;

import com.greenfox.orientationtrialexam.models.Alias;
import com.greenfox.orientationtrialexam.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AliasServiceImpl implements AliasService {

	private final AliasRepository aliasRepository;

	@Autowired
	public AliasServiceImpl(AliasRepository aliasRepository) {
		this.aliasRepository = aliasRepository;
	}


	@Override
	public List<Alias> getAllAliases() {
		return this.aliasRepository.findAll();
	}


	@Override
	public boolean checkIfAliasExistsInDatabase(String alias) {
		return this.aliasRepository.findByAlias(alias).isPresent();
	}


	@Override
	public String decideReaction(String reaction, Long aliasId) {
		if (reaction.equals("success")) {
			Optional<Alias> aliasObject = this.aliasRepository.findById(aliasId);
			if (aliasObject.isPresent()) {
				Alias alias1 = aliasObject.get();

				String alias = alias1.getAlias();
				String secretCode = alias1.getSecretCode();

				return
					"Your URL is aliased to <b>"
					+ alias
					+ "</b> and your secret code is <b>"
					+ secretCode
					+ "</b>.";
			}
		}
		return "Your alias is already in use!";
	}


	@Override
	public String decideColorByReaction(String reaction) {
		if (reaction.equals("fail")) {
			return "red";
		}
		return "black";
	}


	@Override
	public Optional<Alias> findByAlias(String alias) {
		return this.aliasRepository.findByAlias(alias);
	}


	@Override
	public Optional<Alias> findById(Long id) {
		return this.aliasRepository.findById(id);
	}


	@Override
	public void save(Alias alias) {
		this.aliasRepository.save(alias);
	}


	@Override
	public void delete(Alias alias) {
		this.aliasRepository.delete(alias);
	}
}