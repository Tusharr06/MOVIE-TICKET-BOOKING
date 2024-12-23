package com.tushar.MovieBookingApp.repositries;


import com.tushar.MovieBookingApp.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
        Theater findByAddress(String address);
    }

