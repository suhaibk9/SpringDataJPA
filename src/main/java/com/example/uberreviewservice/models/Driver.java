package com.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel{
    private String name;
    @Column(nullable = false)
    private String licenseNumber;
    @OneToMany(mappedBy = "driver",fetch=FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings=new ArrayList<>();
}
