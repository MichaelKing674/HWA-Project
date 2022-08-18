package com.qa.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Long> {
	
    Driver findDriverByLastName(String lastName);
    
    @Query(value = "SELECT * from driver WHERE team = ?1", nativeQuery = true)
    List<Driver> findDriverByTeam(String team);
    
    @Query(value = "SELECT d from Driver d WHERE d.wins = ?1")
    List<Driver> findDriverByWins(int wins);
    
}
