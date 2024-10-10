package com.practice.catsgram.service;

import com.practice.catsgram.exceptions.InvalidEmailException;
import com.practice.catsgram.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final UserService userService;
    private List<Post> posts = new ArrayList<>();

    public PostService(UserService userService) {
        this.userService = userService;
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post create(Post post){
        if(userService.findUserByEmail(post.getAuthor())==null){
            throw new InvalidEmailException("Пользователь не найден");

        }
        posts.add(post);
        return post;
    }

}
