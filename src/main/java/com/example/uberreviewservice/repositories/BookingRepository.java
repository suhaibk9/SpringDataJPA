package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    List<Booking> findAllByDriverId(Long driverId);
    List <Booking>  findAllByDriverIn(List<Driver> drivers);
}

