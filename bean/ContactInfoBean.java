package com.capgemini.airlinereservationsystem.bean;

import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ContactInfoBean {
	private long contactNo;
	private String contactName;
	private String flightCompany;
}
