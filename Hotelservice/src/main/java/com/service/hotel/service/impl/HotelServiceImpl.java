package com.service.hotel.service.impl;

import com.service.hotel.entity.Hotel;
import com.service.hotel.exception.ResourceNotFoundException;
import com.service.hotel.repository.HotelRepo;
import com.service.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        Hotel hotel1 = hotelRepo.save(hotel);
        return hotel1;
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotels = hotelRepo.findAll();
        return hotels;
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found : " + hotelId));
    }

    @Override
    public Hotel updateHotelDetail(String hotelId, Hotel hotel) {
        Hotel hotel1 = hotelRepo.findById(hotelId)
                .map(hotelData -> {
                    hotelData.setHotelName(hotel.getHotelName());
                    hotelData.setCity(hotel.getCity());
                    hotelData.setAbout(hotel.getAbout());
                    return hotelRepo.save(hotelData);
                }).orElseThrow(() -> new ResourceNotFoundException("The hotel with given id not found : " + hotelId));
        return hotel1;
    }


}
