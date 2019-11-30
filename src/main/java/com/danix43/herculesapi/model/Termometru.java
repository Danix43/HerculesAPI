package com.danix43.herculesapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@Table(name = "meteoseekers", schema = "herculespai")
public class Termometru {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "location")
	private String location;

	@Column(name = "firstinsert")
	private Timestamp firstInsert;
	
	@Column(name = "lastinsert")
	private Timestamp lastInsert;
	
	@Column(name = "temperatureCelsius")
	private double tempCelsius;
	
	@Column(name = "heatIndexCelsius")
	private double heatIndexCelsius;
	
	@Column(name = "temperatureKelvin")
	private double tempKelvin;
	
	@Column(name = "heatIndexKelvin")
	private double heatIndexKelvin;
	
	@Column(name = "temperatureFahrenheit")
	private double tempFahrenheit;
	
	@Column(name = "heatIndexFahrenheit")
	private double heatIndexFahrenheit;
	
	@Column(name = "humidity")
	private double humidity;

}
