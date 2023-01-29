package com.micrsoservice.rating.service;

import com.micrsoservice.rating.entity.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

    void deleteRatingByUser(String userId);

    void deleteRatingById(String ratingId);

}
