package com.practice.catsgram.service;

import com.practice.catsgram.exceptions.InvalidEmailException;
import com.practice.catsgram.exceptions.UserAlreadyExistException;
import com.practice.catsgram.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();


    public Collection<User> findAll() {
        return users.values();
    }


    public User create( User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Почта пользователя не может быть пустой");
        }

        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с такой почтой уже существует");
        }

        users.put(user.getEmail(), user);
        return user;
    }

    public User findUserByEmail(String email){
       /* if(users.containsKey(user.getEmail())){
            return user;
        }*/
        if(users.containsKey(email)){
            return users.get(email);
        }

        return null;
    }

    public User findByEmail(String userEmail){
        if(users.containsKey(userEmail)){
            return users.get(userEmail);
        }
        return null;
    }


    public User update( User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Почта пользователя не может быть пустой");
        }

        users.put(user.getEmail(), user);
        return user;
    }
}
