package com.tushar.MovieBookingApp.exceptions;

public class TheaterIsExist extends RuntimeException{


	public TheaterIsExist() {
        super("Theater is already Present on this Address");
    }
}
