package com.tushar.MovieBookingApp.exceptions;

public class UserExist extends RuntimeException {

	public UserExist() {
        super("User Already Exists with this EmailId");
    }
}
