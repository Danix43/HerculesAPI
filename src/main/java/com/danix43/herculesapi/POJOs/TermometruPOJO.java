package com.danix43.herculesapi.POJOs;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TermometruPOJO {
	
	private String name;
	
	private String location;

	private Timestamp firstInsert;
	
	private Timestamp lastInsert;
	
	private double temperatureInCelsius;
	
	private double heatIndexCelsius;
	
	private double temperatureInKelvin;
	
	private double heatIndexKelvin;
	
	private double temperatureInFahrenheit;
	
	private double heatIndexFahrenheit;
	
	private double humidity;
	
}
