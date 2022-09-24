/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootobfy.restcontroller;

import com.springbootobfy.dto.User;
import com.springbootobfy.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andyb
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/users")
    public void addUser(@RequestBody User user){
         userService.save(user);
    }
}
