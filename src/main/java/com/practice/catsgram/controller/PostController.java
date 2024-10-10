package com.practice.catsgram.controller;

import com.practice.catsgram.model.Post;
import com.practice.catsgram.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    private List<Post> posts = new ArrayList<>();

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {

        return postService.create(post);
    }
}
