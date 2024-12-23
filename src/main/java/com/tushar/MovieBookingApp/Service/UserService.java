package com.tushar.MovieBookingApp.Service;

import com.tushar.MovieBookingApp.convertor.UserConvertor;
import com.tushar.MovieBookingApp.entity.User;
import com.tushar.MovieBookingApp.exceptions.UserExist;
import com.tushar.MovieBookingApp.repositries.UserRepository;
import com.tushar.MovieBookingApp.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserRequest userRequest) {
        Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());

        if (users.isPresent()) {
            throw new UserExist();
        }

        User user = UserConvertor.userDtoToUser(userRequest);

        userRepository.save(user);
        return "User Saved Successfully";
    }

}