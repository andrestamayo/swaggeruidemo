/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootobfy.services;

import com.springbootobfy.dao.EmployeeDao;
import com.springbootobfy.dao.UserDao;
import com.springbootobfy.dto.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andyb
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    
    public void save(User user){
        userDao.saveUser(user);
    }
}
