package com.tushar.MovieBookingApp.request;

import com.tushar.MovieBookingApp.Enums.Gender;
import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
    private String roles;
}