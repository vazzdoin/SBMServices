package com.user.service.userservice.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private String hotelId;
    private String hotelName;
    private String city;
    private String about;
}
