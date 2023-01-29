package com.user.service.userservice.entity.rating;

import com.user.service.userservice.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String comment;

    private Hotel hotel;
}
