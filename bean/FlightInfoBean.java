package com.capgemini.airlinereservationsystem.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class FlightInfoBean {
	private String flightId;
	private LocalDate departureDate;
	private LocalTime departureTime;
	private LocalDate arrivalDate;
	private LocalTime arrivalTime;
	private String source;
	private String destination;
	private double fare;
	private int totalSeats;
	private int availableSeat;
}
