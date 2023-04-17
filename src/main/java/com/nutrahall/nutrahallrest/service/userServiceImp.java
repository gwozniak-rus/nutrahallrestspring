package com.nutrahall.nutrahallrest.service;


import com.nutrahall.nutrahallrest.data.User;
import com.nutrahall.nutrahallrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


@Service
public class userServiceImp implements UserService {

    //try with getUser with query
    private final EntityManager entityManager;

    @Autowired
    public userServiceImp(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }


  /*  @Override
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

    }*/

    /*@Override
    public User getUser(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }*/
    @Override
    public User getUser(User userDetails){
        
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "FROM User WHERE username = :username AND password = :password AND firstname = :firstname AND lastname = :lastname", User.class);
        try{
            User user = new User();
            user = typedQuery.setParameter("username", userDetails.getUsername())
                    .setParameter("password",userDetails.getPassword())
                    .setParameter("firstname",userDetails.getFirstname())
                    .setParameter("lastname",userDetails.getLastname()).getSingleResult();
            return typedQuery.getSingleResult();

        }catch (Exception e) {
            return null;
        }
    }

   // @Override
    /*public User updateUser(User user){
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
    }*/
}
