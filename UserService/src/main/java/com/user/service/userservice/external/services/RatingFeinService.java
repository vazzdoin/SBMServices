package com.user.service.userservice.external.services;

import com.user.service.userservice.entity.rating.Rating;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RATINGS-SERVICE")
public interface RatingFeinService {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatings(@PathVariable String userId);

    //Create
    @PostMapping("/ratings")
    Rating createRating(@RequestBody Rating rating);

    //PUT
    @PutMapping("/rating/{ratingId}")
    Rating updateRating(@RequestBody Rating rating, @PathVariable String ratingId);
}
