package com.capgemini.airlinereservationsystem.bean;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class TicketInfoBean {
	private int noOfSeats;
	private String ticketId;
	private UserInfoBean userDetails;
	private FlightInfoBean flightDetails;
	private double totalFair;
	private String status;

}
