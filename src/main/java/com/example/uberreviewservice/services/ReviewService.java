package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private ReviewRepository reviewRepository;
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from Service!");
     Review r1=   Review.builder()
             .content("Good Quality")
             .Rating(5.0)
             .build();//To  create a POJO object
        Review r2=Review.builder()
                .content("Bad Quality")
                .Rating(1.0)
                .build();//To  create a POJO object
        reviewRepository.save(r1);//Executing the SQL query
        reviewRepository.save(r2);//Executing the SQL query
        //List of All Reviews
        reviewRepository.deleteById(2L);
        System.out.println("Details "+r1.getContent()+"    "+r2.getContent());
        List<Review> reviews=reviewRepository.findAll();
        for(Review review:reviews){
            System.out.println(review.toString());
        }
    }
}
