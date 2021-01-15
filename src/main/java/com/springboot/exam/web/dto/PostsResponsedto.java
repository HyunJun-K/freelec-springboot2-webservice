package com.springboot.exam.web.dto;

import com.springboot.exam.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponsedto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponsedto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
