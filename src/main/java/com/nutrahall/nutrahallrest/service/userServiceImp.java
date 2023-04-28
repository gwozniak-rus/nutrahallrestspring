package com.nutrahall.nutrahallrest.service;


import com.nutrahall.nutrahallrest.data.Code;
import com.nutrahall.nutrahallrest.data.User;
import com.nutrahall.nutrahallrest.repository.CodeRepository;
import com.nutrahall.nutrahallrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


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
    @Autowired
    CodeRepository codeRepository;

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }


    //this is a try
    @Override
    public List<User> listUsers(){
        List<User> users = new ArrayList<>();
        Streamable.of(userRepository.findAll())
                .forEach(users::add);
        return users;
    }


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


    //this will send code to database
    @Override
    public Code addCode(Code code){

        return codeRepository.save(code);
    }

//this verifies the code from react
    @Override
    public Code findCode(Code codeDetails){
        TypedQuery<Code> typedQuery = entityManager.createQuery(
                "FROM Code WHERE code = :code", Code.class);
        try{
            Code code = new Code();
            code = typedQuery.setParameter("code", codeDetails.getCode()).getSingleResult();
            return typedQuery.getSingleResult();
        }catch (Exception e){
            return null;
        }

    }


}
