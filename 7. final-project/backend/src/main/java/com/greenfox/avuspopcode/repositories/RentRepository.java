package com.greenfox.avuspopcode.repositories;

import com.greenfox.avuspopcode.entities.Rent;
import com.greenfox.avuspopcode.enums.RentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

  @Query(value = "SELECT rent FROM Rent rent where rent.status in :statusList AND rent.user.id = :userId")
  Set<Rent> findByUserIdAndStatus(Long userId, List<RentStatus> statusList);

  @Query(value = "SELECT * FROM rent WHERE status != 'AVAILABLE'", nativeQuery = true)
  Set<Rent> findNotAvailableRents();

  @Query(value = "SELECT * FROM rent WHERE status != 'AVAILABLE' AND vehicle_id = :vehicleId", nativeQuery = true)
  Set<Rent> pendingRentAlreadyExists(Long vehicleId);

  Set<Rent> findByUserId(Long userId);
}