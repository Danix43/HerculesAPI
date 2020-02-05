package com.herculesapi.model;

import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TermometruPOJO extends Termometru {

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
