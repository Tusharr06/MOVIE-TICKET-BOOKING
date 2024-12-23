package com.tushar.MovieBookingApp.exceptions;

public class MovieDoesNotExists extends RuntimeException {


	public MovieDoesNotExists() {
		super("Movie dose not Exists");
	}
}
