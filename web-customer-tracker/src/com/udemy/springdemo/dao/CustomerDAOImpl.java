package com.udemy.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemy.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query amd get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return results
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer to db
		currentSession.saveOrUpdate(theCustomer);
		
		//have method save/update or saveorupdate if they have an id
		
		
		
		
	}


	@Override
	public Customer getCustomer(int theId) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//now retrieve read from databse using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
		
	}


	@Override
	public void deleteCustomer(int theId) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete the obkect with the prim key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

	
	
}
