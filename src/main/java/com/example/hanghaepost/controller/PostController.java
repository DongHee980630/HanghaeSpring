package com.example.hanghaepost.controller;

import com.example.hanghaepost.dto.PostRequestsDto;
import com.example.hanghaepost.entity.Post;
import com.example.hanghaepost.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestsDto requestsDto){

        return postService.createPost(requestsDto);
    }
    @GetMapping("/api/posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }
}
