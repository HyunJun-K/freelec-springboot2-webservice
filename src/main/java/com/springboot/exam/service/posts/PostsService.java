package com.springboot.exam.service.posts;

import com.springboot.exam.domain.posts.Posts;
import com.springboot.exam.domain.posts.PostsRepository;
import com.springboot.exam.web.dto.PostsSaveRequestDTO;
import com.springboot.exam.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO){
        return postsRepository.save(requestDTO.toEntity()).getId();
    }

    @Transactional
    public Long update(long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없음. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }


    public void delete (Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }


}

