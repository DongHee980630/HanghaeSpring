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

    @Transactional
    public Long update(Long id, PostRequestsDto requestsDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!post.getPassword().equals(requestsDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        post.update(requestsDto);
        return post.getId();
    }

    @Transactional
    public long deletePost(Long id, PostRequestsDto requestsDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!post.getPassword().equals(requestsDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        postRepository.deleteById(id);
        return id;
    }
}
