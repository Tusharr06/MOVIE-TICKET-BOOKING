package com.tushar.MovieBookingApp.convertor;


import com.tushar.MovieBookingApp.entity.Show;
import com.tushar.MovieBookingApp.entity.Ticket;
import com.tushar.MovieBookingApp.response.TicketResponse;

public class TicketConvertor {

    public static TicketResponse returnTicket(Show show, Ticket ticket) {
        TicketResponse ticketResponseDto = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .time(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}