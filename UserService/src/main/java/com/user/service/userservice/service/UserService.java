package com.user.service.userservice.service;

import com.user.service.userservice.entity.User;

import java.util.List;

public interface UserService {

    //Create User
    User saveUser(User user);

    //Get All users
    List<User> getAllUsers();

    //get single user with Id
    User getUser(String userId);

    //TODO : Delete and Update User
}
