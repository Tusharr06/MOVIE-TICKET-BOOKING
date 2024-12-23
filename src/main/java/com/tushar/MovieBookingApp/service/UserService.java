package com.tushar.MovieBookingApp.service;


import java.util.Optional;

import com.tushar.MovieBookingApp.convertor.UserConvertor;
import com.tushar.MovieBookingApp.entity.User;
import com.tushar.MovieBookingApp.exceptions.UserExist;
import com.tushar.MovieBookingApp.repositries.UserRepository;
import com.tushar.MovieBookingApp.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserRequest userRequest) {
        Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());

        if (users.isPresent()) {
            throw new UserExist();
        }

        User user = UserConvertor.userDtoToUser(userRequest,  passwordEncoder.encode("1234"));

        userRepository.save(user);
        return "User Saved Successfully";
    }

}