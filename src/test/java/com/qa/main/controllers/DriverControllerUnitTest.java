package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Driver;
import com.qa.main.services.DriverService;

@WebMvcTest
public class DriverControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private DriverService service;
	
	@Test
	public void createTest() throws Exception {
		Driver entry = new Driver("Max", "Verstappen", "RedBull", 28, 70);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Driver response = new Driver(2L,"Max", "Verstappen", "RedBull", 28, 70);
		String responseAsJSON = mapper.writeValueAsString(response);
		
		Mockito.when(service.create(entry)).thenReturn(response);
		
		mvc.perform(post("/driver/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void readAllTest() throws Exception {
		List<Driver> response = new ArrayList<>();
		response.add(new Driver(2L,"Max", "Verstappen", "RedBull", 28, 70));
		String responseAsJSON = mapper.writeValueAsString(response);
		
		Mockito.when(service.getAll()).thenReturn(response);
		
		mvc.perform(get("/driver/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void readByIdTest() throws Exception {
		Driver entry = new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188);
		
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(service.getByID(1L)).thenReturn(entry);
		
		mvc.perform(get("/driver/getByID/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void readByName() throws Exception {
		Driver entry = new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188);
		
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(service.getByLastName("Hamilton")).thenReturn(entry);
		
		mvc.perform(get("/driver/getByLastName/Hamilton")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void readByTeamTest() throws Exception {
		
		List<Driver> response = new ArrayList<>();
		response.add(new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188));
		
		String responseAsJSON = mapper.writeValueAsString(response);
		
		Mockito.when(service.getByTeam("Mercedes")).thenReturn(response);
		
		mvc.perform(get("/driver/getByTeam/Mercedes")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void readByWins() throws Exception {
		
		List<Driver> response = new ArrayList<>();
		response.add(new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188));
		
		String responseAsJSON = mapper.writeValueAsString(response);
		
		Mockito.when(service.getByWins(103)).thenReturn(response);
		
		mvc.perform(get("/driver/getByWins/103")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		
		Driver entry = new Driver(1L,"Max", "Verstappen", "RedBull", 28, 70);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(service.update(1L, entry)).thenReturn(entry);
		
		mvc.perform(put("/driver/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		
		Mockito.when(service.remove(1)).thenReturn(true);
		mvc.perform(delete("/driver/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}



















