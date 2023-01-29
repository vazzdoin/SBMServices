package com.user.service.userservice.external.services;

import com.user.service.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelFeinService {

    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
