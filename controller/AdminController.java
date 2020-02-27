package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import com.capgemini.airlinereservationsystem.bean.FlightInfoBean;
import com.capgemini.airlinereservationsystem.bean.UserInfoBean;
import com.capgemini.airlinereservationsystem.service.FlightInfoService;
import com.capgemini.airlinereservationsystem.service.FlightInfoServiceImpl;
import com.capgemini.airlinereservationsystem.service.TicketInfoService;
import com.capgemini.airlinereservationsystem.service.TicketInfoServiceImpl;
import com.capgemini.airlinereservationsystem.service.UserInfoService;
import com.capgemini.airlinereservationsystem.service.UserInfoServiceImpl;

public class AdminController {
	
	private UserInfoService userService = UserInfoServiceImpl.getUserInfoService();
	private FlightInfoService flightService = FlightInfoServiceImpl.getFlightInfoService();
	private TicketInfoService ticketService = TicketInfoServiceImpl.getTicketInfoService();

	Scanner scanner = new Scanner(System.in);

	String adminId;

	public AdminController() {
		getAuthenticate();
	}
	
	public void getAuthenticate() {
		System.out.println("Enter your USERID");
		this.adminId = scanner.next();
		System.out.println("Enter your password");
		String password = scanner.next();

		if(userService.userAuthentication(this.adminId, password)) {
			getAdminfunction();
		} else {
			System.out.println("Invalid Credential! try again");
			getAuthenticate();
		}
	}
	
	public void getAdminfunction() {
		System.out.println("Enter 1 for Add User");
		System.out.println("Enter 2 for Add Flight");
		System.out.println("Enter 3 for View Reserved Tickets");
		System.out.println("Enter 4 for View Cancelled Tickets");
		System.out.println("Enter 5 for go back");
		System.out.println("Enter your choice");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			if (addUser()) {
				System.out.println("User Added Successfully");
			} else {
				System.out.println("Failed to Add User");
			}
			break;
		case 2:
			if(addFlight()) {
				System.out.println("Flight Added Successfully");
			} else {
				System.out.println("Failed to Add Flight");
			}
			break;
		case 3:
			viewReservedTicket();
			break;
		case 4:
			viewCancelledTicket();
			break;
		case 5:
			MainController mainController = new MainController();
			mainController.getStart();
			break;
		default :
			System.out.println("Wrong Choice! Try Again");
			getAdminfunction();
		}

	}

	private void viewCancelledTicket() {
		System.out.println("Enter Flight Id which cancelled seat you are looking for");
		String flightId = scanner.next();
		ticketService.viewCancelledTicket(flightId);
	}

	private void viewReservedTicket() {
		System.out.println("Enter Flight Id which reserved seat you are looking for");
		String flightId = scanner.next();
		ticketService.viewReservedTicket(flightId);
	}

	private boolean addFlight() {
		
		FlightInfoBean flightInfoBean=new FlightInfoBean();
		System.out.println("Enter Flight Id");
		flightInfoBean.setFlightId(scanner.next());
		System.out.println("Enter Departure Date and Time");
		//flightInfoBean.setDepartureDate();
		System.out.println("Enter Source");
		flightInfoBean.setSource(scanner.next());
		System.out.println("Enter Destination");
		flightInfoBean.setDestination(scanner.next());
		
		
		flightService.addFlight(flightInfoBean);
		
		return true;
	}

	private boolean addUser() {
		UserInfoBean user = new UserInfoBean();
		System.out.println("Enter User Id");
		user.setUserId(scanner.next());
		System.out.println("Enter First Name");
		user.setFirstName(scanner.next());
		System.out.println("Enter Last Name");
		user.setLastName(scanner.next());
		System.out.println("Enter Nationality");
		user.setNationality(scanner.next());
		System.out.println("Enter Residence");
		user.setResidence(scanner.next());
		System.out.println("Enter Mobile Number");
		user.setMobile(scanner.nextLong());
		System.out.println("Enter Email Address");
		user.setMail(scanner.next());
		System.out.println("Enter Password");
		user.setPassword(scanner.next());
		System.out.println("Enter Role");
		user.setRole(scanner.next());

		// call the service method for register the user

		return true;

	}

}
