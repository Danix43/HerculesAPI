package com.danix43.herculesapi.POJOs;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TermometruPOJO {
	
	private String name;
	
	private Timestamp firstinsert;
	
	private Timestamp lastinsert;
	
	private String location;
	
	private double tempCelsius;
	
	private double heatIndexCelsius;
	
	private double tempKelvin;
	
	private double tempFahrenheit;
	
	private double heatIndexFahrenheit;
	
	private double humidity;

}
