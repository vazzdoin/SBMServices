package com.service.hotel.controller;

import com.service.hotel.entity.Hotel;
import com.service.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //create hotel
    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        String uniqueId = UUID.randomUUID().toString();
        hotel.setHotelId(uniqueId);
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    //get single
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> findById(@PathVariable String hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    //get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.ok(hotels);
    }

    @PostMapping("/update/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId, @RequestBody Hotel hotel) {
        Hotel hotel1 = hotelService.updateHotelDetail(hotelId, hotel);
        return ResponseEntity.ok(hotel1);
    }
}
