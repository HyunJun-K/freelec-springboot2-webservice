package com.springboot.exam.web;

import com.springboot.exam.domain.posts.PostsRepository;
import com.springboot.exam.service.posts.PostsService;
import com.springboot.exam.web.dto.PostsResponsedto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model M){
        M.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "post-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){

        PostsResponsedto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "post-update";
    }

}
