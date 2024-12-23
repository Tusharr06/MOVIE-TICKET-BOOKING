package com.tushar.MovieBookingApp.Service;

import com.tushar.MovieBookingApp.convertor.MovieConvertor;
import com.tushar.MovieBookingApp.convertor.UserConvertor;
import com.tushar.MovieBookingApp.entity.Movie;
import com.tushar.MovieBookingApp.entity.User;
import com.tushar.MovieBookingApp.exceptions.MovieAlreadyExist;
import com.tushar.MovieBookingApp.exceptions.UserExist;
import com.tushar.MovieBookingApp.repositries.MovieRepository;
import com.tushar.MovieBookingApp.repositries.UserRepository;
import com.tushar.MovieBookingApp.request.MovieRequest;
import com.tushar.MovieBookingApp.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Service
    public static class UserService {

        @Autowired
        UserRepository userRepository;


        public String addUser(UserRequest userRequest) {
            Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());

            if (users.isPresent()) {
                throw new UserExist();
            }

            User user = UserConvertor.userDtoToUser(userRequest);

            userRepository.save(user);
            return "User Saved Successfully";
        }

    }
}
