package com.greenfox.backendapiexercises.repositories;

import com.greenfox.backendapiexercises.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
