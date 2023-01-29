package com.user.service.userservice.service.Impl;

import com.user.service.userservice.entity.Hotel;
import com.user.service.userservice.entity.User;
import com.user.service.userservice.entity.rating.Rating;
import com.user.service.userservice.external.services.HotelFeinService;
import com.user.service.userservice.external.services.RatingFeinService;
import com.user.service.userservice.repository.UserRepository;
import com.user.service.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelFeinService hotelFeinService;

    @Autowired
    private RatingFeinService ratingFeinService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String userId = UUID .randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceAccessException("User with given ID doesn't't exist in the DB : " + userId));

        //Fetch ratings of the user
        Rating[] userRatings;
        String url = "http://RATINGS-SERVICE/ratings/users/"+userId;
//        userRatings = restTemplate.getForObject(url, Rating[].class);

//        logger.info("Rating : "+userRatings);
        List<Rating> ratings = ratingFeinService.getRatings(userId);
//        List<Rating> ratings = Arrays.stream(userRatings).toList();
        logger.info("Rating info {} "+ratings);
        ratings.stream().map(rating -> {
            //api call to hotel
            // http://localhost:8082/hotels/188cdf72-71cb-4794-a107-e66b5bcf80b7
//            ResponseEntity<Hotel> hotelData = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = hotelData.getBody();
            logger.info("Rating id : "+rating.getRatingId());
            if(null != rating.getRatingId()) {
                Hotel hotel = null;
                try {
                    hotel = hotelFeinService.getHotel(rating.getHotelId());
                } catch (Exception ex) {
                    logger.error("Error : {} ",ex.getMessage());
                }
                logger.info("{} " + hotel);
                //set the hotel rating
                rating.setHotel(hotel);
            }
            //return the hotel detail
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratings);
        return user;
    }
}
