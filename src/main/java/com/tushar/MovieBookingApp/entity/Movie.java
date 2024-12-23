package com.tushar.MovieBookingApp.entity;

import com.tushar.MovieBookingApp.Enums.Genre;
import com.tushar.MovieBookingApp.Enums.Language;
import jakarta.persistence.Table;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
    @Table(name = "MOVIES")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String movieName;

        private Integer duration;

        @Column(scale = 2)
        private Double rating;

        private Date releaseDate;

        @Enumerated(value = EnumType.STRING)
        private Genre genre;

        @Enumerated(value = EnumType.STRING)
        private Language language;

        @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
        private List<Show> shows = new ArrayList<>();
    }

