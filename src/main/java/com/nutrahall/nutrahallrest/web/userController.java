package com.nutrahall.nutrahallrest.web;

import com.nutrahall.nutrahallrest.data.User;
import com.nutrahall.nutrahallrest.request.UserRequest;
import com.nutrahall.nutrahallrest.response.UserResponse;
import com.nutrahall.nutrahallrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin(origins = "http://localhost:8080")
public class userController {

    @Autowired
    UserService userService;

//adding a user
    @PostMapping(value = "/add")
    public ResponseEntity<UserResponse>addUser(@RequestBody UserRequest user){
        UserResponse newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    //get
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<User>getUser(@PathVariable("id") Integer id ){
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    //find all

    //update
    //needs work(may need to add the auto-incremented id
    @PutMapping(value = "/update/{username}")
    public ResponseEntity<User>updateUser(@PathVariable("username") String username,
                                          @RequestBody User user){
        user.setUsername(username);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    //authenticate method??

    //delete method(deletemapping)
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }





}
