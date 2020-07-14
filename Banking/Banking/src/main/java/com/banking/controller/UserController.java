package com.banking.controller;

import com.banking.domain.User;
import com.banking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/new")
    public User createUser(@RequestBody User user){
        return this.userService.newUser(user);
    }
}
