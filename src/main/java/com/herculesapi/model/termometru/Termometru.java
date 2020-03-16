package com.herculesapi.model.termometru;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@Table(name = "meteoseekers", schema = "herculespai")
@XmlRootElement(name = "termometru")
public class Termometru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int termometruId;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "firstinsert")
    @CreationTimestamp
    private Timestamp firstInsert;

    @Column(name = "lastinsert")
    @UpdateTimestamp
    private Timestamp lastInsert;

    @Column(name = "temperatureincelsius", precision = 2)
    private double temperatureInCelsius;

    @Column(name = "heatindexcelsius", precision = 2)
    private double heatIndexCelsius;

    @Column(name = "temperatureinkelvin", precision = 2)
    private double temperatureInKelvin;

    @Column(name = "heatindexkelvin", precision = 2)
    private double heatIndexKelvin;

    @Column(name = "temperatureinfahrenheit", precision = 2)
    private double temperatureInFahrenheit;

    @Column(name = "heatindexfahrenheit", precision = 2)
    private double heatIndexFahrenheit;

    @Column(name = "humidity", precision = 2)
    private double humidity;

}
