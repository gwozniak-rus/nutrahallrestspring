package com.nutrahall.nutrahallrest.web;

import com.nutrahall.nutrahallrest.data.User;
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
    /*@PostMapping(value = "/add")
    public ResponseEntity<UserResponse>addUser(@RequestBody UserRequest user){
        UserResponse newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }*/


   /* @PostMapping(value = "/add")
    public ResponseEntity<User>addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }*/
    @PostMapping(value = "/add")
    public User addUser(@RequestBody User user) {
        if (user.getFirstname() == null) {
            throw new RuntimeException("Firstname is empty");
        } else {
            return userService.addUser(user);
        }
    }

    //get
   //@GetMapping(value = "/get/{username}")
    @PutMapping(value = "/add/User")
   //public ResponseEntity<User>getUser(@RequestBody User user ){
     public User getUser(@RequestBody User user){
        return userService.getUser(user);
        //user = userService.getUser(user);
            //return new ResponseEntity<>(user, HttpStatus.OK);
    }
    //find all


    //update
    //needs work(may need to add the auto-incremented id
   /* @PutMapping(value = "/update/{username}")
    public ResponseEntity<User>updateUser(@PathVariable("username") String username,
                                          @RequestBody User user){
        user.setUsername(username);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }


    //delete method(deletemapping)
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }*/





}
