package com.tushar.MovieBookingApp.convertor;

import com.tushar.MovieBookingApp.entity.Theater;
import com.tushar.MovieBookingApp.request.TheaterRequest;

public class TheaterConvertor {

        public static Theater theaterDtoToTheater(TheaterRequest theaterRequest) {
            Theater theater = Theater.builder()
                    .name(theaterRequest.getName())
                    .address(theaterRequest.getAddress())
                    .build();
            return theater;
        }
    }

