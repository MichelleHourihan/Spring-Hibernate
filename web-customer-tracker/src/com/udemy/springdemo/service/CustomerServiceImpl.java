package com.udemy.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.springdemo.dao.CustomerDAO;
import com.udemy.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO thecustomerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return thecustomerDao.getCustomers();
		
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		thecustomerDao.saveCustomer(theCustomer);
		
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

}
