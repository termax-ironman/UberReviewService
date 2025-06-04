package org.example.uberreviewservice.ReviewService;

import org.example.uberreviewservice.Repository.ReviewRepository;
import org.example.uberreviewservice.models.Review;
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
        System.out.print("*******************************");
        Review r = Review
                .builder()
                .content("gulu gulu ride")
                .rating(78.8)
                .build();
        System.out.println(r);
        reviewRepository.save(r); //this code executes sql query

        List<Review> reviews = reviewRepository.findAll();
        for(Review review : reviews) {
            System.out.println(review.getContent());
        }
        reviewRepository.deleteById(2L);
    }
}
