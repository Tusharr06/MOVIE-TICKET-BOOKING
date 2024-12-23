package com.tushar.MovieBookingApp.convertor;

import com.tushar.MovieBookingApp.entity.Show;
import com.tushar.MovieBookingApp.request.ShowRequest;

import java.sql.Date;


public class ShowConvertor {

    public static Show showDtoToShow(ShowRequest showRequest) {
        Show show = Show.builder()
                .time(showRequest.getShowStartTime())
                .date((Date) showRequest.getShowDate())
                .build();

        return show;
    }
}
