package com.service.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @Column(name = "HOTEL_ID")
    private String hotelId;
    @Column(name = "HOTEL_NAME")
    private String hotelName;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ABOUT")
    private String about;
}
