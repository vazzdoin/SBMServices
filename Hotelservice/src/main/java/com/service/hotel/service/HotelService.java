package com.service.hotel.service;

import com.service.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotelById(String hotelId);

    Hotel updateHotelDetail(String hotelId, Hotel hotel);
}
