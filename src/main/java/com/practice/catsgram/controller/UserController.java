package com.practice.catsgram.controller;

import com.practice.catsgram.exceptions.InvalidEmailException;
import com.practice.catsgram.exceptions.UserAlreadyExistException;
import com.practice.catsgram.model.User;
import com.practice.catsgram.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {

        userService.create(user);
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
       userService.update(user);
        return user;
    }

    @GetMapping("users/userEmail")
    public User findByEmail(@PathVariable String userEmail){
       return userService.findByEmail(userEmail);
    }
}
