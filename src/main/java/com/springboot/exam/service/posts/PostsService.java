package com.springboot.exam.service.posts;

import com.springboot.exam.domain.posts.Posts;
import com.springboot.exam.web.dto.PostsListResponseDto;
import com.springboot.exam.domain.posts.PostsRepository;
import com.springboot.exam.web.dto.PostsResponsedto;
import com.springboot.exam.web.dto.PostsSaveRequestDTO;
import com.springboot.exam.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("err not find id. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponsedto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new NoResultException("err not find id="+ id));
        return new PostsResponsedto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not find ID"));
        postsRepository.delete(posts);

    }


}

