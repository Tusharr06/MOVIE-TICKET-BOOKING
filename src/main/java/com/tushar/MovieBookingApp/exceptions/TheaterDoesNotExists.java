package com.tushar.MovieBookingApp.exceptions;

public class TheaterDoesNotExists extends RuntimeException {

	public TheaterDoesNotExists() {
		super("Theater does not Exists");
	}
}
