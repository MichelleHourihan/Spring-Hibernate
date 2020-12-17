package com.barriga.entities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.sql.Date;

public class Calendar {

	private LocalDateTime firstDay;
	private Month month;
	private LocalDateTime today;
	private int weekOfYear;
	private LocalDateTime firstCalDayOfMonth;
	private ArrayList<LocalDateTime> daysOfMonth = new ArrayList<LocalDateTime>();
	private ArrayList<TimeSlot> slotsInWeek = new ArrayList<TimeSlot>();
	private ArrayList<Booking> bookings = new ArrayList<Booking>();
	LocalDateTime firstDayOfWeek;

	////////////////////////////////////////////////////////////////////////////////
	// set default to today's date
	public Calendar() {
		today = LocalDateTime.now(ZoneId.of("UTC"));

	}

	////////////////////////////////////////////////////////////////////////////////
	public Calendar(String date) {
		today = LocalDateTime.parse(date);
	}

	////////////////////////////////////////////////////////////////////////////////
	public LocalDateTime getFirstDay() {
		firstDay = LocalDateTime.of(today.getYear(), today.getMonthValue(), 1, 0, 0);

		return firstDay;
	}

	/////////////////////////////////////////////////////////////////////////////
	public Month getMonth() {
		month = today.getMonth();
		return month;
	}

	////////////////////////////////////////////////////////////////////////////
	public LocalDateTime getToday() {
		return today;
	}

	//////////////////////////////////////////////////////////////////////////
	public void setNextMonth() {
		this.today = this.today.plusMonths(1);
		
	}

	///////////////////////////////////////////////////////////////////////////////
	public void setLastMonth() {
		this.today = this.today.plusMonths(-1);
		
	}

	//////////////////////////////////////////////////////////////////////////////
	public void setNextWeek() {
		this.today = this.today.plusWeeks(1);
	}

	//////////////////////////////////////////////////////////////////////////////
	public void setLastWeek() {
		this.today = this.today.plusWeeks(-1);
	}

	////////////////////////////////////////////////////////////////////////////////////////

	public int getWeekOfYear() {

		TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
		this.weekOfYear = today.get(woy);

		return this.weekOfYear;
	}

	///////////////////////////////////////////////////////////////////////////////
	public LocalDateTime getFirstCalDayOfMonth() {
		
		firstDay = getFirstDay();

		int valueOfFirstDay = firstDay.getDayOfWeek().getValue();
		
		if (valueOfFirstDay == 7) {
			firstCalDayOfMonth = firstDay;
		} else {
			firstCalDayOfMonth = firstDay.plusDays(-(valueOfFirstDay));
		}
		
		return firstCalDayOfMonth;

	}
	/////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<LocalDateTime> getDaysOfMonth() {

		firstCalDayOfMonth = getFirstCalDayOfMonth();

		for (int i = 0; i < 35; i++) {
			this.daysOfMonth.add(firstCalDayOfMonth);
			firstCalDayOfMonth = firstCalDayOfMonth.plusDays(1);
		}

		return daysOfMonth;
	}

	////////////////////////////////////////////////////////////////////////////////////////
	private LocalDateTime setAddHour() {
		
		return today = today.plusHours(1);
	}
	////////////////////////////////////////////////////////////////////////////
	public ArrayList<Booking> getBookings() {
		
		return bookings;
	}
	////////////////////////////////////////////////////////////
	public void setBookings(ArrayList<Booking> bookings) {
		
		this.bookings = bookings;
	}
	///////////////////////////////////////////////////////////////////////////

	public ArrayList<TimeSlot> getSlotsInWeek() {
		return this.slotsInWeek;
	}

	///////////////////////////////////////////////////////////////////////////////////////////
	public void setSlotsInWeek() {
		// firstDayOfWeek = getFirstDayWeek();
		firstDayOfWeek = getFirstDayWeek();
		firstDayOfWeek = firstDayOfWeek.withHour(7).withMinute(0).withSecond(0).withNano(0);

		int minutes = 0;
		while ((firstDayOfWeek.getHour() < 19)) {

			for (int j = 0; j < 7; j++) {

				LocalDateTime temp = firstDayOfWeek;
				this.slotsInWeek.add(new TimeSlot(null, firstDayOfWeek, temp.plusMinutes(15).withNano(0), true));
				firstDayOfWeek = firstDayOfWeek.plusDays(1).withNano(0);
			}

			firstDayOfWeek = getFirstDayWeek();
			// System.out.println("In loop:" + firstDayOfWeek);
			firstDayOfWeek = firstDayOfWeek.withHour(7).withMinute(0).withSecond(0);
			minutes += 15;
			firstDayOfWeek = firstDayOfWeek.plusMinutes(minutes).withNano(0);

		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////
	public LocalDateTime getFirstDayWeek() {

		int valueOfToday = today.getDayOfWeek().getValue();
		// System.out.print(valueOfToday);
		if (valueOfToday == 7) {
			firstDayOfWeek = today;
		} else {
			firstDayOfWeek = today.plusDays(-(valueOfToday));
		}
		return firstDayOfWeek;

	}
	///////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<TimeSlot> getSlots(ArrayList<Booking> bookings) {
		ArrayList<TimeSlot> timeslots = new ArrayList<TimeSlot>();
		for (int i = 0; i < bookings.size(); i++) {
			timeslots.addAll(bookings.get(i).getBookingslots());
		}
		/*
		 * for(int j = 0; j < timeslots.size(); j++) {
		 * timeslots.get(j).setStart(timeslots.get(j).getStart().withNano(0)); //
		 * System.out.println(bookings.get(i).getBookingslots());
		 * System.out.println("in loop" + timeslots.get(j).getStart()); }
		 */

		return timeslots;
	}

	////////////////////////////////////////////////////////////////////////////////////
	public void checkSlots(ArrayList<TimeSlot> bookedslots) {
		for (int i = 0; i < this.slotsInWeek.size(); i++) {
			for (int j = 0; j < bookedslots.size(); j++) {
				// System.out.println("Start of slots week" +
				// slotsInWeek.get(i).getStart().withNano(0));
				// System.out.println("Start of booked" + bookedslots.get(j).getStart());
				if (this.slotsInWeek.get(i).getStart().withNano(0).equals(bookedslots.get(j).getStart().withNano(0))) {
					System.out.println("They are the same");
					this.slotsInWeek.set(i, bookedslots.get(j));
				}
			}
		}
		///////////////////////////////////////////////////////////////////////////////////////
	}

}
