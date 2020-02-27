package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.capgemini.airlinereservationsystem.bean.FlightInfoBean;
import com.capgemini.airlinereservationsystem.db.InfoDB;

public class FlightInfoDAOImpl implements FlightInfoDAO {

	public static FlightInfoDAO getFlightInfoDAO() {
		return new FlightInfoDAOImpl();
	}
	
	@Override
	public Collection<FlightInfoBean> getAllFlight(String source, String destination) {
		ArrayList<FlightInfoBean> allFlight = new ArrayList<FlightInfoBean>();
		for (FlightInfoBean flightDetails : InfoDB.flightInfoDb) {
			if(flightDetails.getSource().equals(source) && flightDetails.getDestination().equals(destination)) {
				allFlight.add(flightDetails);
			}
		}
		return allFlight;
	}

	@Override
	public boolean addFlight(FlightInfoBean flight) {
		if(InfoDB.flightInfoDb.add(flight)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateFlightDetails(String flightId, FlightInfoBean flight) {
		FlightInfoBean flightInfoBean=null;
		for (FlightInfoBean flightDetail : InfoDB.flightInfoDb) {
			if(flightDetail.getFlightId().equals(flightId)) {
				flightInfoBean = flightDetail;
			} else {
				return false;
			}
		}
		flightInfoBean.setArrivalDate(flight.getArrivalDate());
		flightInfoBean.setArrivalTime(flight.getArrivalTime());
		flightInfoBean.setDepartureDate(flight.getDepartureDate());
		flightInfoBean.setDepartureTime(flight.getDepartureTime());
		flightInfoBean.setDestination(flight.getDestination());
		flightInfoBean.setSource(flight.getSource());
		
		return true;
	}

}
