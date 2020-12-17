package com.barriga.controller;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.barriga.entities.Booking;
import com.barriga.entities.Calendar;
import com.barriga.entities.TimeSlot;
import com.barriga.service.BookingService;




@Controller
public class HelloWorldController {
	
	//need to inject service into controller to access DAO
	@Autowired
	private BookingService bookingService;
	
	//controller for homepage
	@RequestMapping("/") 
	public String showPage(Model model){
		
		//create a calendar object 
		Calendar calendar = new Calendar();
		
		//add the calendar to the model
		model.addAttribute("calendar", calendar);
		
		//create an arraylist of local date time to store the dates from calendar object to use in the model
		ArrayList<LocalDateTime> theDaysofMonth = new ArrayList <LocalDateTime>();
		theDaysofMonth = calendar.getDaysOfMonth();
		
		//add the dates to the model
		model.addAttribute("daysOfMonth", theDaysofMonth);
		
		//return view of calendar
		return "monthlyIndex";
	}
	
	
	//controller for the next calendar month
	@GetMapping("/next")
	
	//request the current day 'today' as param from the view 
	public String nextMonth(@RequestParam("today") String today
			, Model model)
	{
		
		//create a calendar object that is initialised with today's date as a parameter
		Calendar calendar = new Calendar(today);
		calendar.setNextMonth();
		model.addAttribute("calendar", calendar);
		ArrayList<LocalDateTime> theDaysofMonth = new ArrayList <LocalDateTime>();
		//calendar.setDaysOfMonth();
		theDaysofMonth = calendar.getDaysOfMonth();
		model.addAttribute("daysOfMonth", theDaysofMonth);

		return "monthlyIndex";
	}
	
	//controller for last calendar month
	@GetMapping("/last")
	public String LastMonth(@RequestParam("today") String today
			, Model model)
	{
	
		Calendar calendar = new Calendar(today);
		calendar.setLastMonth();
		model.addAttribute("calendar", calendar);
		ArrayList<LocalDateTime> theDaysofMonth = new ArrayList <LocalDateTime>();
		theDaysofMonth = calendar.getDaysOfMonth();
		model.addAttribute("daysOfMonth", theDaysofMonth);
	
		return "monthlyIndex";
	}
	
	//controller for weekly calendar view
	@GetMapping("/weekCalendar")
	public String weeklyCalendar(Model model)
	{
		Calendar calendar = new Calendar();
		model.addAttribute("calendar", calendar);
		ArrayList<TimeSlot> slotsInWeek = new ArrayList<TimeSlot>();
		calendar.setSlotsInWeek();
		ArrayList<Booking> bookings = (ArrayList<Booking>) bookingService.getBooking();
		calendar.checkSlots(calendar.getSlots(bookings));
		slotsInWeek = calendar.getSlotsInWeek();
		model.addAttribute("slotsInWeek", slotsInWeek);
		
		

		return "weeklyIndex";
	}
	
	//controller for following week
	@GetMapping("/nextWeek")
	public String nextWeek(@RequestParam("today") String today
			, Model model)
	{
		
		Calendar calendar = new Calendar(today);
		calendar.setNextWeek();
		model.addAttribute("calendar", calendar);
		ArrayList<TimeSlot> slotsInWeek = new ArrayList<TimeSlot>();
		calendar.setSlotsInWeek();	
		ArrayList<Booking> bookings = (ArrayList<Booking>) bookingService.getBooking();
		calendar.checkSlots(calendar.getSlots(bookings));
		slotsInWeek = calendar.getSlotsInWeek();
		model.addAttribute("slotsInWeek", slotsInWeek);
		

		return "weeklyIndex";
	}
	
	//controller for previous week
	@GetMapping("/lastWeek")
	public String LastWeek(@RequestParam("today") String today
			, Model model)
	{
		Calendar calendar = new Calendar(today);
		calendar.setLastWeek();
		model.addAttribute("calendar", calendar);
		ArrayList<TimeSlot> slotsInWeek = new ArrayList<TimeSlot>();
		calendar.setSlotsInWeek();
		ArrayList<Booking> bookings = (ArrayList<Booking>) bookingService.getBooking();
		calendar.checkSlots(calendar.getSlots(bookings));
		slotsInWeek = calendar.getSlotsInWeek();
		model.addAttribute("slotsInWeek", slotsInWeek);

		return "weeklyIndex";
	}

	@GetMapping("/saveSlot")
	public String saveSlot(@RequestParam("temp") LocalDateTime temp
			, Model model)
	{
		return null;
	}

	@GetMapping("/popup")
	public String popup(@RequestParam("temp") String temp, Model model) {
		
		LocalDateTime dateTime = LocalDateTime.parse(temp);
		//  Date sqlDate = Date.valueOf(temp);
		//  System.out.print(sqlDate);
		
	
		model.addAttribute("temp", dateTime);
		return "popup";
	}
}

	
	




