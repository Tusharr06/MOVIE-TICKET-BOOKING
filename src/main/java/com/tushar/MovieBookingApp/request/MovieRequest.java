package com.tushar.MovieBookingApp.request;

import com.tushar.MovieBookingApp.Enums.Genre;
import com.tushar.MovieBookingApp.Enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class MovieRequest {
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}