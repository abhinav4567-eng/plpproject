package com.capgemini.airlinereservationsystem.db;

import java.util.HashSet;

import com.capgemini.airlinereservationsystem.bean.ContactInfoBean;
import com.capgemini.airlinereservationsystem.bean.FlightInfoBean;
import com.capgemini.airlinereservationsystem.bean.TicketInfoBean;
import com.capgemini.airlinereservationsystem.bean.UserInfoBean;

public class InfoDB {

	public static final HashSet<UserInfoBean> userInfoDb = new HashSet<UserInfoBean>();
	public static final HashSet<FlightInfoBean> flightInfoDb = new HashSet<FlightInfoBean>();
	public static final HashSet<ContactInfoBean> contactInfoDb = new HashSet<ContactInfoBean>();
	public static final HashSet<TicketInfoBean> ticketInfoDb = new HashSet<TicketInfoBean>();

	static {
		ContactInfoBean conBean1 = new ContactInfoBean();
			conBean1.setFlightCompany("GoAir");
			conBean1.setContactName("Uday Verma");
			conBean1.setContactNo(1234567890l);
			
		ContactInfoBean conBean2 = new ContactInfoBean();
			conBean2.setFlightCompany("IndiGo");
			conBean2.setContactName("Abhinav Singh");
			conBean2.setContactNo(9074099249l);
		
		ContactInfoBean conBean3 = new ContactInfoBean();
			conBean3.setFlightCompany("AirAsia");
			conBean3.setContactName("Vikas Agrawal");
			conBean3.setContactNo(9074099249l);
		
		ContactInfoBean conBean4 = new ContactInfoBean();
			conBean4.setFlightCompany("AirIndia");
			conBean4.setContactName("Aporve Bhatnagar");
			conBean4.setContactNo(9074099249l);
			
		ContactInfoBean conBean5 = new ContactInfoBean();
			conBean5.setFlightCompany("AirIndia");
			conBean5.setContactName("Shubhankit Gautam");
			conBean5.setContactNo(9074099249l);	

		InfoDB.contactInfoDb.add(conBean1);
		InfoDB.contactInfoDb.add(conBean2);
		InfoDB.contactInfoDb.add(conBean3);
		InfoDB.contactInfoDb.add(conBean4);
		InfoDB.contactInfoDb.add(conBean5);

	}
	
	
	static {
		FlightInfoBean flight1 = new FlightInfoBean();
		flight1.setFlightId("Flight1");
		flight1.setSource("Bengaluru");
		flight1.setDestination("Delhi");
		
		FlightInfoBean flight2 = new FlightInfoBean();
		flight2.setFlightId("Flight2");
		flight2.setSource("Bengaluru");
		flight2.setDestination("Chennai");
		
		FlightInfoBean flight3 = new FlightInfoBean();
		flight3.setFlightId("Flight3");
		flight3.setSource("Bengaluru");
		flight3.setDestination("Bhopal");

	}
	
	static {
		UserInfoBean user1 = new UserInfoBean();
		user1.setUserId("architagar");
		user1.setPassword("1234");
		user1.setRole("admin");
		
		UserInfoBean user2 = new UserInfoBean();
		user2.setUserId("nethra");
		user2.setPassword("1234");
		user2.setRole("admin");
		
		UserInfoBean user3 = new UserInfoBean();
		user3.setUserId("ramya");
		user3.setPassword("1234");
		user3.setRole("passenger");
		
		UserInfoBean user4 = new UserInfoBean();
		user4.setUserId("abhinav");
		user4.setPassword("1234");
		user4.setRole("passenger");
		
		InfoDB.userInfoDb.add(user1);
		InfoDB.userInfoDb.add(user2);
		InfoDB.userInfoDb.add(user3);
		InfoDB.userInfoDb.add(user4);
	}

}
