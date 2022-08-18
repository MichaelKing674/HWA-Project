package com.qa.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.domain.Driver;
import com.qa.main.exceptions.DriverNotFoundException;
import com.qa.main.repos.DriverRepo;

@Service
public class DriverService {
	
	private DriverRepo repo;
	
	public DriverService(DriverRepo repo) {
		this.repo = repo;
	}
	
	public Driver create(Driver driver) {
		return this.repo.saveAndFlush(driver);
	}
	
	
	public List<Driver> getAll() {
		return this.repo.findAll();
	}
	public Driver getByID(long id) { 
		return repo.findById(id).orElseThrow(DriverNotFoundException::new);
	}
	public Driver getByLastName(String lastName) {
		return repo.findDriverByLastName(lastName);
	}
	public List<Driver> getByWins(int wins) {
		return repo.findDriverByWins(wins);
	}
	public List<Driver> getByTeam(String team){
		return repo.findDriverByTeam(team);
	}
	
	
	public Driver update(long id,Driver driver) {
		
		Driver existing = this.repo.findById(id).orElseThrow(DriverNotFoundException::new);
		existing.setFirstName(driver.getFirstName());
		existing.setLastName(driver.getLastName());
		existing.setTeam(driver.getTeam());
		existing.setWins(driver.getWins());
		existing.setPodiumFinishes(driver.getPodiumFinishes());
		return this.repo.save(existing);
	}
	
	
	public boolean remove(long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
