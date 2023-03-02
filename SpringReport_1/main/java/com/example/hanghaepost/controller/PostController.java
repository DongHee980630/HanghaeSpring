package com.example.hanghaepost.controller;

import com.example.hanghaepost.dto.PostRequestsDto;
import com.example.hanghaepost.entity.Post;
import com.example.hanghaepost.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/posts") public Post createPost(@RequestBody PostRequestsDto requestsDto){

        return postService.createPost(requestsDto);
    }
    @GetMapping("/api/posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestsDto requestDto){
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestsDto requestDto){
        return postService.deletePost(id, requestDto);
    }
}
