package com.tushar.MovieBookingApp.exceptions;

public class ShowDoesNotExists extends RuntimeException {


	public ShowDoesNotExists() {
		super("Show does not exists");
	}
}
