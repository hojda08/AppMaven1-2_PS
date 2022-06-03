package com.example.RezervariAppMaven.api;

import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Reviews;
import com.example.RezervariAppMaven.service.MagazineService;
import com.example.RezervariAppMaven.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("reviews")
@RestController
public class ControllerReviews {

    private ReviewsService reviewsService;

    @Autowired
    public ControllerReviews(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping
    public void addReview(@RequestBody Reviews review){
        reviewsService.addReview(review);
    }

    @GetMapping
    public List<Reviews> findReviews(){
        return reviewsService.findReviews();
    }

    @GetMapping(path = "{numeProdus}")
    public List<Reviews> findReviewsByNumeProdus(@PathVariable("numeProdus") String numeProdus){
        return reviewsService.findReviewByNumeProdus(numeProdus);
    }

}
