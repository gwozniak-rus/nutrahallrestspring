package com.nutrahall.nutrahallrest.web;

import com.nutrahall.nutrahallrest.data.Code;
import com.nutrahall.nutrahallrest.data.User;
import com.nutrahall.nutrahallrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping(path = "/api/user")
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*")
public class userController {

    @Autowired
    UserService userService;


//this adds user for registration activity
    @PostMapping(value = "/add")
    public User addUser(@RequestBody User user) {
        if (user.getFirstname() == null) {
            throw new RuntimeException("Firstname is empty");
        } else {
            return userService.addUser(user);
        }
    }

//this is the query for login activity
    @PutMapping(value = "/add/User")
     public User getUser(@RequestBody User user){
        return userService.getUser(user);
    }
    //this is a try
    //this lists user_table for react
    @GetMapping(value = "/getUsers")
    public List<User>listUsers(){

        return userService.listUsers();
    }
    //sending the code to the database from android studio
    @PostMapping(value = "/addCode")
    public Code addCode(@RequestBody Code code){
        return userService.addCode(code);
    }
   @PutMapping(value = "/findCode")
    public Code findCode(@RequestBody Code code){
        return userService.findCode(code);
   }





}
