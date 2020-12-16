package com.barriga.entities;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Calendar calendar = new Calendar();
		System.out.println(calendar.getMonth());
		/*System.out.println(calendar.getDay());
		System.out.println(calendar.getDaysInMonth());
		System.out.println(calendar.getFirstDay());
		System.out.println(calendar.getNextMonth());
		System.out.println(calendar.getLastMonth());
		System.out.println(calendar.getLastMonth());
		System.out.println(calendar.getNextMonth());*/
		//Month month = calendar.getNextMonth();
		//calendar.setMonth(month);
		//System.out.println(calendar.getMonth());
		//calendar.setNextMonth();
		//calendar.setNextMonth();
		System.out.println("Today:" + calendar.getToday());
		
	   // System.out.println(calendar.getDaysOfMonth());
	
	//	System.out.println(calendar.getDaysInMonth());
		//System.out.println(calendar.firstDay);
		System.out.println("First Calendar Day: " + calendar.getFirstCalDayOfMonth()); 
		System.out.println("Today:" + calendar.getToday());
		/*TimeSlot timeslot = new TimeSlot();
		timeslot.setStart(LocalDateTime.now());
		timeslot.setFinish(LocalDateTime.now().plusMinutes(15));
		timeslot.setDuration();
		System.out.println(timeslot.getDuration());
		LocalDateTime start = LocalDateTime.of(2015, 
                Month.JULY, 29, 19, 30);
		LocalDateTime finish = start.plusMinutes(30);

		Booking booking = new Booking ("Michelle", "michelle@yahoo.ie", "0873662690", start, finish );
		System.out.println(booking.getStart());
		System.out.println(booking.getFinish());
		//booking.setDuration();
		System.out.println(booking.getDuration());*/


//booking.setBookingslots();
//System.out.println("Booking slots:" + booking.getBookingslots());
		//calendar.setLastWeek();
		//calendar.setLastWeek();

		
//System.out.print("First Day of Week:" + calendar.getFirstDayWeek());
calendar.setSlotsInWeek();
//System.out.print("Days in Week" + calendar.getSlotsInWeek());

	
	/* Test the array of booking */
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		LocalDateTime start1 = LocalDateTime.of(2020,  Month.OCTOBER, 29, 07, 00);
		LocalDateTime finish1 = start1.plusMinutes(30);
		
		LocalDateTime start2 = LocalDateTime.of(2020,  Month.OCTOBER, 30, 07, 00);
		LocalDateTime finish2 = start2.plusMinutes(30);
		
		LocalDateTime start3 = LocalDateTime.of(2020,  Month.NOVEMBER, 10 , 07, 00);
		LocalDateTime finish3 = start3.plusMinutes(30);
		
		//bookings.add(new Booking("Michelle", "michelle@email.com", "123", start1, finish1));
		//bookings.add(new Booking("Fred", "michelle@email.com", "123", start2, finish2));
		bookings.add(new Booking("Bob", "michelle@email.com", "123", start3, finish3));
		//System.out.print(bob.getBookingslots());
		//System.out.println(bookings.get(0).getBookingslots());
		//System.out.println(bookings.get(1).getBookingslots());
		//System.out.println(bookings.get(2).getBookingslots());

		System.out.println("Slots" + calendar.getSlots(bookings));

		calendar.checkSlots(calendar.getSlots(bookings));
		System.out.println("Bookings" + calendar.getSlotsInWeek());
		

	}
	
	

}
