package com.danix43.herculesapi.POJOs;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class TermometruPOJO {
	
	private String name;
	
	private String location;

	private Timestamp firstInsert;
	
	private Timestamp lastInsert;
	
	private double tempCelsius;
	
	private double heatIndexCelsius;
	
	private double tempKelvin;
	
	private double heatIndexKelvin;
	
	private double tempFahrenheit;
	
	private double heatIndexFahrenheit;
	
	private double humidity;

}
