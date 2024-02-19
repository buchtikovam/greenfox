package com.greenfox.avuspopcode.services;

import com.greenfox.avuspopcode.dtos.RentPutDTO;
import com.greenfox.avuspopcode.entities.Rent;
import com.greenfox.avuspopcode.enums.RentStatus;

import java.util.List;
import java.util.Set;

public interface RentService {

  Rent findRentById(Long id);

  Set<Rent> getRentsByUserIdAndStatus(Long userId, List<String> statusList);

  void saveRent(Long userId, Long vehicleId);

  void updateRentsStatus(RentPutDTO rentPutDTO);
  
  Set<Rent> findByUserId(Long userId);
}