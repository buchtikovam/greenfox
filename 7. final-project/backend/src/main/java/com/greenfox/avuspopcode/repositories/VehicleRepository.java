package com.greenfox.avuspopcode.repositories;

import com.greenfox.avuspopcode.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  @Query(value = "SELECT * FROM vehicle", nativeQuery = true)
  Set<Vehicle> findAllVehicles();
}