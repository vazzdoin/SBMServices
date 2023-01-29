package com.micrsoservice.rating.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("user_ratings")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String comment;

}
