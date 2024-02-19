package com.greenfox.exam.services;

import com.greenfox.exam.models.Manufacturer;
import java.util.Optional;

public interface ManufacturerService {

	boolean existsByName(String name);

	Optional<Manufacturer> findByName(String name);
}
