package com.danix43.herculesapi.model.termometru;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iottermometru", schema = "central")
public class Termometru {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	private String name;
	
	private Timestamp firstinsert;
	
	private Timestamp lastinsert = Timestamp.valueOf(LocalDateTime.now());
	
	private double tempCelsius;
	
	private double tempKelvin;
	
	private double tempFahrenheit;
	
	private double humidity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Timestamp getFirstinsert() {
		return firstinsert;
	}

	public void setFirstinsert(Timestamp firstinsert) {
		this.firstinsert = firstinsert;
	}

	public Timestamp getLastinsert() {
		return lastinsert;
	}

	public void setLastinsert(Timestamp lastinsert) {
		this.lastinsert = lastinsert;
	}

	public double getTempCelsius() {
		return tempCelsius;
	}

	public void setTempCelsius(double tempCelsius) {
		this.tempCelsius = tempCelsius;
	}

	public double getTempKelvin() {
		return tempKelvin;
	}

	public void setTempKelvin(double tempKelvin) {
		this.tempKelvin = tempKelvin;
	}

	public double getTempFahrenheit() {
		return tempFahrenheit;
	}

	public void setTempFahrenheit(double tempFahrenheit) {
		this.tempFahrenheit = tempFahrenheit;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	
}
