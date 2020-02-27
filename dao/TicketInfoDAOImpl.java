package com.capgemini.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.capgemini.airlinereservationsystem.bean.FlightInfoBean;
import com.capgemini.airlinereservationsystem.bean.TicketInfoBean;
import com.capgemini.airlinereservationsystem.bean.UserInfoBean;
import com.capgemini.airlinereservationsystem.db.InfoDB;

public class TicketInfoDAOImpl implements TicketInfoDAO {

	public static TicketInfoDAO getTicketInfoDAO() {
		return new TicketInfoDAOImpl();
	}

	@Override
	public boolean bookFlightTicket(String userId, String flightId, int noOfSeats) {
		UserInfoBean userBean = null;
		FlightInfoBean flightBean = null;
		for (UserInfoBean userDetails : InfoDB.userInfoDb) {
			if (userDetails.getUserId().equals(userId)) {
				userBean = userDetails;
			} else {
				return false;
			}
		}
		for (FlightInfoBean flightDetails : InfoDB.flightInfoDb) {
			if (flightDetails.getFlightId().equals(flightId)) {
				flightBean = flightDetails;
			} else {
				return false;
			}
		}
		TicketInfoBean ticketBean = new TicketInfoBean();
		ticketBean.setFlightDetails(flightBean);
		ticketBean.setUserDetails(userBean);
		ticketBean.setStatus("reserved");
		ticketBean.setTicketId(userId + "#" + flightId);
		ticketBean.setTotalFair(flightBean.getFare() * noOfSeats);
		flightBean.setAvailableSeat(flightBean.getAvailableSeat() - noOfSeats);
		return true;
	}

	@Override
	public Collection<TicketInfoBean> viewReservedTicket(String flightId) {
		List<TicketInfoBean> collectionTickets = null;
		for (TicketInfoBean ticketDetails : InfoDB.ticketInfoDb) {
			if (ticketDetails.getFlightDetails().getFlightId().equals(flightId)
					&& ticketDetails.getStatus().equals("reserved")) {
				collectionTickets.add((TicketInfoBean) Arrays.asList(ticketDetails));
			}
		}
		return collectionTickets;
	}

	@Override
	public Collection<TicketInfoBean> viewCancelledTicket(String flightId) {
		List<TicketInfoBean> collectionTickets = null;
		for (TicketInfoBean ticketDetails : InfoDB.ticketInfoDb) {
			if (ticketDetails.getFlightDetails().getFlightId().equals(flightId)
					&& ticketDetails.getStatus().equals("cancelled")) {
				collectionTickets.add((TicketInfoBean) Arrays.asList(ticketDetails));
			}
		}
		return collectionTickets;
	}

	@Override
	public boolean cancelReservedTicket(String ticketId) {
		for (TicketInfoBean ticketBean : InfoDB.ticketInfoDb) {
			if (ticketBean.getTicketId().equals(ticketId)) {

				ticketBean.setStatus("cancelled");
				ticketBean.getFlightDetails()
						.setAvailableSeat(ticketBean.getNoOfSeats() + ticketBean.getFlightDetails().getAvailableSeat());
				return true;
			}
		}
		return false;
	}

}
