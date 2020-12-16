package com.barriga.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.barriga.entities.Booking;


@Repository
public class BookingDAOImpl implements BookingDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Booking> getBooking() {
		
Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Booking> theQuery = currentSession.createQuery("from Booking", Booking.class);
		
		//execute query amd get result list
		List<Booking> bookings = theQuery.getResultList();
		
		//return results
		return bookings;
		
	}

	@Override
	public void saveBooking(Booking theBooking) {
		// TODO Auto-generated method stub

	}

	@Override
	public Booking getBooking(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(int theId) {
		// TODO Auto-generated method stub

	}

}
