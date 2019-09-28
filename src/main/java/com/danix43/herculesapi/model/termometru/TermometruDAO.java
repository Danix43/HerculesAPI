package com.danix43.herculesapi.model.termometru;

import java.sql.Timestamp;

public class TermometruDAO {
	
	private String name;
	
	private Timestamp firstinsert;
	
	private Timestamp lastinsert;
	
	private double tempCelsius;
	
	private double tempKelvin;
	
	private double tempFahrenheit;
	
	private double humidity;

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
