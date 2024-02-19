package com.greenfox.exam.services;

import com.greenfox.exam.models.Manufacturer;
import com.greenfox.exam.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	private final ManufacturerRepository manufacturerRepository;

	@Autowired
	public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
		this.manufacturerRepository = manufacturerRepository;
	}

	@Override
	public boolean existsByName(String name) {
		return this.manufacturerRepository.findByName(name).isPresent();
	}

	@Override
	public Optional<Manufacturer> findByName(String name) {
		return this.manufacturerRepository.findByName(name);
	}
}