package com.barriga.dao;

import java.util.List;

import com.barriga.entities.Booking;



public interface BookingDAO {
	
	public List<Booking> getBooking();

	public void saveBooking(Booking theBooking);

	public Booking getBooking(int theId);

	public void deleteBooking(int theId);

}
