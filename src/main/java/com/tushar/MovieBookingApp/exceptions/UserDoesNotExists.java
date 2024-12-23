package com.tushar.MovieBookingApp.exceptions;;

public class UserDoesNotExists extends RuntimeException {

	public UserDoesNotExists() {
		super("User does not exists");
	}
}
