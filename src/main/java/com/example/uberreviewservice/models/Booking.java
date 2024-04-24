package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseModel{
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Review review;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus status;
    @Temporal(value = TemporalType.DATE)
    private Date startTime;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;
    private Long totalDistance;
    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;
}
