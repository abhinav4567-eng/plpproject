package com.capgemini.airlinereservationsystem.bean;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class UserInfoBean {

	private String userId;
	private String firstName;
	private String lastName;
	private String nationality;
	private String residence;
	private long mobile;
	private String mail;
	private String password;
	private String role;
	private String gender;
}
