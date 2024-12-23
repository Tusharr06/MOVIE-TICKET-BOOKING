package com.tushar.MovieBookingApp.exceptions;
public class SeatsNotAvailable extends RuntimeException {

	public SeatsNotAvailable() {
		super("Requested Seats Are Not Available");
	}
}
