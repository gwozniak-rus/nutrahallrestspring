package com.nutrahall.nutrahallrest.service;

import com.nutrahall.nutrahallrest.data.Code;
import com.nutrahall.nutrahallrest.data.User;
import com.nutrahall.nutrahallrest.request.UserRequest;
import com.nutrahall.nutrahallrest.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    User addUser(User user);

    List<User> listUsers();//this is a try

    User getUser(User user);

    //this will send code to database
    Code addCode(Code code);

    //this verifies the code from react
    Code findCode(Code code);


}
