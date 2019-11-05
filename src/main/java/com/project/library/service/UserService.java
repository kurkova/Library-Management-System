package com.project.library.service;

import com.project.library.domain.User;
import com.project.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(final User user){
        return userRepository.save(user);
    }

    public Optional<User> getUser (final Long id){
        return userRepository.findById(id);
    }
}
