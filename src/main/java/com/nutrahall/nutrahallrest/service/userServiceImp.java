package com.nutrahall.nutrahallrest.service;


import com.nutrahall.nutrahallrest.data.User;
import com.nutrahall.nutrahallrest.repository.UserRepository;
import com.nutrahall.nutrahallrest.request.UserRequest;
import com.nutrahall.nutrahallrest.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class userServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse addUser(UserRequest userRequest){
        //return userRepository.save(user);
        User newUser = new User();
        newUser.setFirstname(userRequest.getFirstname());
        newUser.setLastname(userRequest.getLastname());
        newUser.setUsername(userRequest.getUsername());
        newUser.setPassword(userRequest.getPassword());
        //time??
        userRepository.save(newUser);
        return new UserResponse("user created successfully");

    }


    @Override
    public User getUser(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
