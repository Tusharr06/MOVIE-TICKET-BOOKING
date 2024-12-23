package com.tushar.MovieBookingApp.exceptions;

public class TheaterIsNotExist extends RuntimeException{

	public TheaterIsNotExist() {
        super("Theater is not present in this address");
    }
}
