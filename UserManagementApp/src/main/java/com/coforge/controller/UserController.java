package com.coforge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.coforge.entities.User;
import com.coforge.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/{uid}")
    public Optional<User> getUserById(@PathVariable long uid) {
        return service.findById(uid);
    }
}