package com.tushar.MovieBookingApp.Service;
import java.util.List;
import java.util.Optional;

import com.tushar.MovieBookingApp.Enums.SeatType;
import com.tushar.MovieBookingApp.convertor.ShowConvertor;
import com.tushar.MovieBookingApp.entity.*;
import com.tushar.MovieBookingApp.exceptions.MovieDoesNotExists;
import com.tushar.MovieBookingApp.exceptions.TheaterDoesNotExists;
import com.tushar.MovieBookingApp.repositries.MovieRepository;
import com.tushar.MovieBookingApp.repositries.ShowRepository;
import com.tushar.MovieBookingApp.repositries.TheaterRepository;
import com.tushar.MovieBookingApp.request.ShowRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addShow(ShowRequest showRequest) {
        Show show = ShowConvertor.showDtoToShow(showRequest);

        Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());

        if (movieOpt.isEmpty()) {
            throw new MovieDoesNotExists();
        }

        Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());

        if (theaterOpt.isEmpty()) {
            throw new TheaterDoesNotExists();
        }

        Theater theater = theaterOpt.get();
        Movie movie = movieOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);
        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show has been added Successfully";
    }

    public String associateShowSeats(ShowSeatRequest showSeatRequest) throws ShowDoesNotExists {
        Optional<Show> showOpt = showRepository.findById(showSeatRequest.getShowId());

        if (showOpt.isEmpty()) {
            throw new ShowDoesNotExists();
        }

        Show show = showOpt.get();
        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for (TheaterSeat theaterSeat : theaterSeatList) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if (showSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setPrice((showSeatRequest.getPriceOfClassicSeat()));
            } else {
                showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
            }

            showSeat.setShow(show);
            showSeat.setIsAvailable(Boolean.TRUE);
            showSeat.setIsFoodContains(Boolean.FALSE);

            showSeatList.add(showSeat);
        }

        showRepository.save(show);

        return "Show seats have been associated successfully";
    }
}