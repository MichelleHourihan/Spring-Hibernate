package com.barriga.entities;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeSlot {
	private String userName;
	private LocalDateTime start;
	private String start2;
	private LocalDateTime finish;
	private Long duration;
	private boolean free;
	private boolean expired;
	
	
/////////////////////////////////////////////////////////////////////	
	public TimeSlot() {
		
	}
//////////////////////////////////////////////////////////////////////
	public TimeSlot(String userName, LocalDateTime start, LocalDateTime finish, boolean free) {
		this.start = start;
		this.finish = finish;
		this.userName = userName;
		this.free = free;
		setExpired();
		setDuration();
	}
	public String getStart2() {
		this.start2 =start.toString();
		return this.start2;
		
	}
///////////////////////////////////////////////////////////////////////
	public LocalDateTime getStart() {
		return this.start;
		
	}
////////////////////////////////////////////////////////////////////////
	public LocalDateTime getFinish() {
		return this.finish;
		
	}
////////////////////////////////////////////////////////////////////////
	public Long getDuration() {
		return this.duration;
		
	}
/////////////////////////////////////////////////////////////////////////
	public boolean getStatus() {
		return this.free;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}
	public void setDuration() {
		this.duration = Duration.between(start, finish).toMinutes();
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void setExpired() {
		if (this.finish.compareTo(LocalDateTime.now()) > 0 ) {
			this.expired = true;
		}
		else {
			this.expired = false;
		}
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	public boolean isExpired() {
		return this.expired;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "TimeSlot [userName=" + userName + ", start=" + start + ", finish=" + finish + ", duration=" + duration
				+ ", free=" + free + "]";
	}
	
}
