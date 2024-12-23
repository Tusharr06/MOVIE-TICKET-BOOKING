package com.tushar.MovieBookingApp.Service;

import com.tushar.MovieBookingApp.convertor.MovieConvertor;
import com.tushar.MovieBookingApp.entity.Movie;
import com.tushar.MovieBookingApp.exceptions.MovieAlreadyExist;
import com.tushar.MovieBookingApp.repositries.MovieRepository;
import com.tushar.MovieBookingApp.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest) {
        Movie movieByName = movieRepository.findByMovieName(movieRequest.getMovieName());

        if (movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())) {
            throw new MovieAlreadyExist();
        }

        Movie movie = MovieConvertor.movieDtoToMovie(movieRequest);

        movieRepository.save(movie);
        return "The movie has been added successfully";
    }
}
