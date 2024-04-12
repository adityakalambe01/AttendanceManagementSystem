package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.entity.User;
import com.attendancemanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean addNewUser(User newUser){

        return true;
    }
}
