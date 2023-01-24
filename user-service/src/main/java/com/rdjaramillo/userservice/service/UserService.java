package com.rdjaramillo.userservice.service;


import com.rdjaramillo.userservice.entity.User;
import com.rdjaramillo.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById (int id){
        return userRepository.findById(id).orElse(null);
    }
    public User save(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }
}
