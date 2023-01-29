package com.micrsoservice.rating.service;

import com.micrsoservice.rating.entity.Rating;
import com.micrsoservice.rating.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public void deleteRatingByUser(String userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        for(Rating rating : ratings) {
            ratingRepository.deleteById(rating.getRatingId());
            logger.info("Rating deleted for User Id : "+userId+" and Rating Id : "+rating.getRatingId());
        }
    }

    @Override
    public void deleteRatingById(String ratingId) {
        ratingRepository.deleteById(ratingId);
    }


}
