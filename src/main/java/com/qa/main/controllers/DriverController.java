package com.qa.main.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Driver;
import com.qa.main.services.DriverService;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {
	
	private DriverService service;
	
	public DriverController(DriverService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Driver> create(@RequestBody Driver driver) {
		return new ResponseEntity<Driver>(service.create(driver), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Driver>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/getByID/{id}")
	public ResponseEntity<Driver> getByID(@PathVariable long id) {
		return new ResponseEntity<Driver>(service.getByID(id), HttpStatus.FOUND);
	}
	@GetMapping("/getByLastName/{lastName}")
	public ResponseEntity<Driver> getByLastName(@PathVariable String lastName) {
		return new ResponseEntity<Driver>(service.getByLastName(lastName), HttpStatus.FOUND);
	}
	@GetMapping("/getByTeam/{team}")
	public ResponseEntity<List<Driver>> getByTeam(@PathVariable String team){
	return new ResponseEntity<>(service.getByTeam(team), HttpStatus.FOUND);
	}
	@GetMapping("/getByWins/{wins}")
	public ResponseEntity<List<Driver>> getByWins(@PathVariable int wins) {
		return new ResponseEntity<>(service.getByWins(wins), HttpStatus.FOUND);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Driver> update(@PathVariable("id") int id, @RequestBody Driver driver) {
		return new ResponseEntity<Driver>(service.update(id, driver), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable long id) {
		return new ResponseEntity<Boolean>(service.remove(id), HttpStatus.NO_CONTENT);
	}
}
