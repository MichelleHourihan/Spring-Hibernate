package com.barriga.service;

import java.util.List;

import com.barriga.entities.Booking;



public interface BookingService {

	public List<Booking> getBooking();

	public void saveBooking(Booking theBooking);
	
	public Booking getBooking(int start);

	public void deleteBooking(int start);
}
