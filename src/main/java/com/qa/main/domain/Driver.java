package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Driver {
	
	//Columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private long id;
	@Column(name = "First_Name")
	private String firstName;
	@Column(name = "Last_Name", nullable = false)
	private String lastName;
	@Column(name = "Team", nullable = false)
	private String team;
	@Column(name = "Wins", nullable = false)
	private int wins;
	@Column(name = "Podium_Finishes", nullable = false)
	private int podiumFinishes;
	
	public Driver(long id, String firstName, String lastName, String team, int wins, int podiumFinishes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
		this.wins = wins;
		this.podiumFinishes = podiumFinishes;
	}
	
	public Driver(String firstName, String lastName, String team, int wins, int podiumFinishes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
		this.wins = wins;
		this.podiumFinishes = podiumFinishes;
	}
	
	public Driver() {}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getPodiumFinishes() {
		return podiumFinishes;
	}
	public void setPodiumFinishes(int podiumFinishes) {
		this.podiumFinishes = podiumFinishes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, podiumFinishes, team, wins);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& podiumFinishes == other.podiumFinishes && Objects.equals(team, other.team) && wins == other.wins;
	}
	
	
	
	
	
}
