package com.example.hanghaepost.entity;


import com.example.hanghaepost.dto.PostRequestsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    public Post(PostRequestsDto requestsDto) {
        this.title = requestsDto.getTitle();
        this.contents = requestsDto.getContents();
        this.author = requestsDto.getAuthor();
        this.password = requestsDto.getPassword();
    }

    public void update(PostRequestsDto requestsDto) {
        this.title = requestsDto.getTitle();
        this.author = requestsDto.getAuthor();
        this.contents = requestsDto.getContents();
    }

}
