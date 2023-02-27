package com.example.hanghaepost.service;

import com.example.hanghaepost.dto.PostRequestsDto;
import com.example.hanghaepost.entity.Post;
import com.example.hanghaepost.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequestsDto requestsDto){
        Post post = new Post(requestsDto);
        postRepository.save(post);
        return post;
    }
    @Transactional
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }
}
