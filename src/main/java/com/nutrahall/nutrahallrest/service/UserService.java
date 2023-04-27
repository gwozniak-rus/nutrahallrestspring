package com.nutrahall.nutrahallrest.service;

import com.nutrahall.nutrahallrest.data.User;
import com.nutrahall.nutrahallrest.request.UserRequest;
import com.nutrahall.nutrahallrest.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

   // User addUser(User user);
    User addUser(User user);

    //User getUser(Integer id);

   // User updateUser(User user);

   // public void deleteUser(Integer id);

    List<User> listUsers();//this is a try

    User getUser(User user);

    //User listUsers(User user);

    /*@Override
        public User getUser(Integer id){
            Optional<User> optionalUser = userRepository.findById(id);
            return optionalUser.get();
        }*/

    //User getUser(Integer id);
}
