package com.qa.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Driver;
import com.qa.main.repos.DriverRepo;

@SpringBootTest
public class DriverServiceUnitTest {
	
	@Autowired
	private DriverService service;
	
	@MockBean
	private DriverRepo repo;
	
	@Test
	public void testCreate() {
		Driver entry = new Driver("Max", "Verstappen", "RedBull", 28, 70);
		Driver response = new Driver(1L,"Max", "Verstappen", "RedBull", 28, 70);
		
		Mockito.when(repo.saveAndFlush(entry)).thenReturn(response);
		
		assertEquals(response, service.create(entry));

	}
	
	@Test
	public void testReadAll() {
		List<Driver> response = new ArrayList<>();
		response.add(new Driver(2L,"Max", "Verstappen", "RedBull", 28, 70));
		Mockito.when(repo.findAll()).thenReturn(response);
		assertEquals(response, service.getAll());
	}
	
	@Test
	public void testReadByID() {
		
		Driver response = new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188);
		Optional<Driver> optionalDriver = Optional.of(response);
		
		Mockito.when(repo.findById(1L)).thenReturn(optionalDriver);
		
		assertEquals(response, service.getByID(1));
	}
	
	@Test
	public void testReadByTeam() {
		List<Driver> response = new ArrayList<>();
		response.add(new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188));
		
		Mockito.when(repo.findDriverByTeam("Mercedes")).thenReturn(response);
		
		assertEquals(response, service.getByTeam("Mercedes"));
	}
	
	@Test
	public void testReadByLastName() {
		Driver response = new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188);
		
		Mockito.when(repo.findDriverByLastName("Hamilton")).thenReturn(response);
		
		assertEquals(response, service.getByLastName("Hamilton"));
	}
	
	@Test
	public void testReadByWins() {
		List<Driver> response = new ArrayList<>();
		response.add(new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188));
		
		Mockito.when(repo.findDriverByWins(103)).thenReturn(response);
		assertEquals(response, service.getByWins(103));
	}

	@Test
	public void testUpdate() {
		Optional<Driver> existing = Optional.of(new Driver(1L,"Max", "Verstappen", "RedBull", 28, 70));
		Driver entry = new Driver("Lewis", "Hamilton", "Mercedes", 103, 188);
		Driver updated = new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188);
		
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.save(updated)).thenReturn(updated);
		
		assertEquals(updated, service.update(1L, entry));
		
	}
	
	@Test
	public void testDelete() {
		Mockito.when(repo.existsById(1L)).thenReturn(false);
		
		assertTrue(service.remove(1L));
	}
}































