package com.practice.catsgram.controller;

import com.practice.catsgram.model.Post;
import com.practice.catsgram.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    private List<Post> posts = new ArrayList<>();
    int uniqueId=1;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        post.setId(uniqueId);

        return postService.create(post);
    }
    @GetMapping("/posts/{postId}")
    public Post findById(@PathVariable int postId){
        return postService.findById(postId);
    }
    @GetMapping("posts/search")
    public List<Post> searchPosts(@RequestParam String author){
        return postService.search(author);
    }
}
