package com.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Passenger extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "passenger")//Passenger One to Many Booking
    private List<Booking>bookings=new ArrayList<>();
}
