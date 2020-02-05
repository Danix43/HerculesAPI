package com.herculesapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TermometruTrimmed extends Termometru {

	private String name;

	private double temperatureInCelsius;

	private double heatIndexCelsius;

	private double temperatureInKelvin;

	private double heatIndexKelvin;

	private double temperatureInFahrenheit;

	private double heatIndexFahrenheit;

	private double humidity;

}
