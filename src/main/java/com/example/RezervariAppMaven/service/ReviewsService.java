package com.example.RezervariAppMaven.service;

import com.example.RezervariAppMaven.dao.MagazineData;
import com.example.RezervariAppMaven.dao.ReviewsData;
import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {

    private ReviewsData reviewsData;

    @Autowired
    public ReviewsService(ReviewsData reviewsData) {
        this.reviewsData = reviewsData;
    }

    public void addReview(Reviews review){
        reviewsData.insert(review);
    }

    public List<Reviews> findReviews(){
        return reviewsData.selectAll();
    }

    public List<Reviews> findReviewByNumeProdus(String numeProdus){
        return reviewsData.selectAllByNumeProdus(numeProdus);
    }

}
