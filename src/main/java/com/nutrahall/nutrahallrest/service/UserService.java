package com.nutrahall.nutrahallrest.service;

import com.nutrahall.nutrahallrest.data.User;
import com.nutrahall.nutrahallrest.request.UserRequest;
import com.nutrahall.nutrahallrest.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserService {

   // User addUser(User user);
    UserResponse addUser(UserRequest userRequest);

    User getUser(Integer id);

    User updateUser(User user);

    public void deleteUser(Integer id);

}
