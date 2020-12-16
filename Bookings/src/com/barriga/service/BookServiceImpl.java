package com.barriga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barriga.dao.BookingDAO;
import com.barriga.entities.Booking;


@Service
public class BookServiceImpl implements BookingService {
	
	@Autowired
	private BookingDAO thebookingDao;

	@Override
	@Transactional
	public List<Booking> getBooking() {
		return thebookingDao.getBooking();
		
	}

	@Override
	public void saveBooking(Booking theBooking) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Booking getBooking(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(int start) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	@Transactional
	public void saveBooking(Booking theBooking) {
		
		thebookingDao.saveCustomer(theBooking);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return thecustomerDao.getCustomer(theId);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		thecustomerDao.deleteCustomer(theId);
	}
	

	

	}*/

}
