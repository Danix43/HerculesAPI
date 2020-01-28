package com.herculesapi.model;

import lombok.Data;

@Data
public class TermometruTrimmed {

	private String name;

	private double temperatureInCelsius;

	private double heatIndexCelsius;

	private double temperatureInKelvin;

	private double heatIndexKelvin;

	private double temperatureInFahrenheit;

	private double heatIndexFahrenheit;

	private double humidity;

}
