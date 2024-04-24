package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {
    private BookingRepository bookingRepository;
    private ReviewRepository reviewRepository;
    private DriverRepository driverRepository;

    public ReviewService(BookingRepository bookingRepository, ReviewRepository reviewRepository, DriverRepository driverRepository) {
        this.bookingRepository = bookingRepository;
        this.reviewRepository = reviewRepository;
        this.driverRepository = driverRepository;
    }

    //
//    @
@Transactional
    public void run(String... args) throws Exception {
//        System.out.println("Review Service.............");
//        Review r = Review
//                .builder()
//                .content("Good")
//                .Rating(4.5)
//                .build();
//        Booking b = Booking
//                .builder()
//                .review(r)
//                .startTime(new Date())
//                .endTime(new Date())
//                .totalDistance(100L)
//                .build();
//        reviewRepository.save(r);
//        bookingRepository.save(b);
//        List<Review> reviews = reviewRepository.findAll();
//        for (Review review : reviews) {
//            System.out.println(review);
//        }

//    }
//       Optional<Booking> booking = bookingRepository.findById(1L);
//       if (booking.isPresent()) {
//           Booking b = booking.get();
//           bookingRepository.delete(b);
//       }
//   }
     //   Optional<Driver> driver = driverRepository.findByIdAndLicenseNumber(1L, "1234567890");
//        Optional<Driver> driver = driverRepository.findById(1L);
//        if (driver.isPresent()) {
//            Driver d = driver.get();
//            List<Booking>bookings=bookingRepository.findAllByDriverId(1L);
//            for(Booking booking:driver.get().getBookings()){
//                System.out.println(booking.getId());
          //  }
//            System.out.println("Driver Bookings"+driver.get().getBookings());
       // }
//      //  Optional<Booking>b=bookingRepository.findById(1L);
//        Optional<Driver>driver=driverRepository.rawfindByIdAndLicenseNumber(1L,"1234567890");
//     //   Optional<Driver>driver=driverRepository.HibernateindByIdAndLicense(1L,"1234567890");
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//        }
        List<Long>driverIds=new ArrayList<>(Arrays.asList(1L,2L,3L));
        List<Driver>drivers=driverRepository.findAllByIdIn(driverIds);
//        List<Booking>bookings=bookingRepository.findAllByDriverIn(drivers);
        for(Driver driver:drivers){
            List<Booking>b=driver.getBookings();
            b.forEach(booking -> System.out.println(booking.getId()+" "+booking.getDriver().getName()));
        }
    }
}
