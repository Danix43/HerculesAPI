package com.danix43.herculesapi.model.termometru;

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
@Table(name = "iottermometru", schema = "central")
public class Termometru {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
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
