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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Driver;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DriverControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		
		Driver entry = new Driver("Max", "Verstappen", "RedBull", 28, 70);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Driver response = new Driver(2L,"Max", "Verstappen", "RedBull", 28, 70);
		String responseAsJSON = mapper.writeValueAsString(response);
		
		mvc.perform(post("/driver/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void readAllTest() throws Exception {
		
		List<Driver> response = new ArrayList<>();
		
		response.add(new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188));
		
		String responseAsJSON = mapper.writeValueAsString(response);
		
		mvc.perform(get("/driver/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(responseAsJSON));
		
	}
	
	@Test
	public void readByIdTest() throws Exception {
				
		Driver entry = new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188);
		
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		mvc.perform(get("/driver/getByID/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void readByNameTest() throws Exception {
		
		Driver entry = new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188);
		
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		mvc.perform(get("/driver/getByLastName/Hamilton")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void readByTeamTest() throws Exception {
		
		List<Driver> response = new ArrayList<>();
		
		response.add(new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188));
		
		String responseAsJSON = mapper.writeValueAsString(response);
		
		mvc.perform(get("/driver/getByTeam/Mercedes")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void readByWins() throws Exception {
		
		List<Driver> response = new ArrayList<>();
		
		response.add(new Driver(1L, "Lewis", "Hamilton", "Mercedes", 103, 188));
		
		String responseAsJSON = mapper.writeValueAsString(response);
		
		mvc.perform(get("/driver/getByWins/103")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(responseAsJSON));
	}
	
	
	@Test
	public void updateTest() throws Exception {
		
		Driver response = new Driver(1L,"Max", "Verstappen", "RedBull", 28, 70);
		String responseAsJSON = mapper.writeValueAsString(response);
		
		mvc.perform(put("/driver/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(responseAsJSON))
				.andExpect(content().json(responseAsJSON));
		
	}
	
	@Test
	public void deleteTest() throws Exception {
		
		mvc.perform(delete("/driver/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
}


























