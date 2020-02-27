package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

public class MainController {

	public void getStart() {
		System.out.println("Welcome to Airline Reservation System");
		System.out.println("Enter 1 for Admin Login");
		System.out.println("Enter 2 for User Login");
		System.out.println("Enter 3 for Guest");
		
		System.out.println("Enter what you want");
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			AdminController	admin = new AdminController();
			break;
		case 2:
			UserController user = new UserController();
		}
		
		
	}
}
