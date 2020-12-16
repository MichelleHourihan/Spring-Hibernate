package com.barriga.entities;

import java.time.Duration;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="trainee")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phoneNumber;
	
	@Column(name="starts")
	private LocalDateTime start;
	
	@Column(name="finish")
	private LocalDateTime finish;
	
	//@Column(name="duration")
	//private int duration;
	
	//private ArrayList<TimeSlot> bookingslots = new ArrayList<TimeSlot>();

	/////////////////////////////////////////////////////////////////////////////////////
	public Booking() {

	}
	
public Booking(String name, String email, String phoneNumber, LocalDateTime start, LocalDateTime finish) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.start = start;
		this.finish = finish;
		
		getBookingslots();
	}

//////////////////////////////////////////////////////////////////////////////////
	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}
///////////////////////////////////////////////////////////////////////////////////////
	public LocalDateTime getFinish() {
		return finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

	
//////////////////////////////////////////////////////////////////////////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
///////////////////////////////////////////////////////////////////////////////////////
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
////////////////////////////////////////////////////////////////////////////////////////
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
/////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<TimeSlot> getBookingslots() {
		ArrayList<TimeSlot> bookingslots = new ArrayList<TimeSlot>();
		int duration = (int) Duration.between(this.start, this.finish).toMinutes();
		int numberOfSlots = (int)(duration/15);
		for(int i = 0; i < numberOfSlots; i++) {
			bookingslots.add(new TimeSlot(this.name, this.start, this.start.plusMinutes(15), false));
			this.start = this.start.plusMinutes(15);
		
	}
		return bookingslots;
	}
	
/*	public void setBookingslots() {
	int numberOfSlots = (int)(this.duration/15);
	for(int i = 0; i < numberOfSlots; i++) {
		this.bookingslots.add(new TimeSlot(this.name, this.start, this.start.plusMinutes(15), false));
		this.start = this.start.plusMinutes(15);
	}*/
		
	
///////////////////////////////////////////////////////////////////////////////////
/*	public long getDuration() {
		return this.duration;
	}

	public void setDuration() {
		this.duration = (int) Duration.between(this.start, this.finish).toMinutes();*/
		
	}
	

	
	
//////////////////////////////////////////////////////////////////////////////////////////	
	

