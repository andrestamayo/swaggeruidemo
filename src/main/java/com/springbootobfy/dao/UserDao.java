/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootobfy.dao;

import com.springbootobfy.dto.Employee;
import com.springbootobfy.dto.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author andyb
 */
@Service
public class UserDao {
    public User saveUser(User user) {
       return user;
    }

  

    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

}
