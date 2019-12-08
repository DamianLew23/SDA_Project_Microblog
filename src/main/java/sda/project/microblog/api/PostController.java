package sda.project.microblog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sda.project.microblog.dto.PostDto;
import sda.project.microblog.model.Post;
import sda.project.microblog.repository.PostRepository;
import sda.project.microblog.service.PostService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostConstruct
    public void postConstruct() {
        Post post = new Post("Ciekawe czy działa");
        Post post1 = new Post("Janikowski został znokautowany");
        Post post2 = new Post("Ho ho ho");
        Post post3 = new Post("ładna pogoda");
        Post post4 = new Post("Władek");

        List<Post> list = new ArrayList<>();
        list.add(post);
        list.add(post1);
        list.add(post2);
        list.add(post3);
        list.add(post4);

       postRepository.saveAll(list);

   }

    @GetMapping(value = "/posts")
    List<PostDto> listAllPost() {
        return postService.allPostList();
    }

    @PostMapping("/posts")
    @ResponseBody
    ResponseEntity<PostDto> addPost (@RequestBody PostDto postDto) throws IOException {
        PostDto postDtosaved = postService.addPostDto(postDto);
        return new ResponseEntity<>(postDtosaved, HttpStatus.CREATED);
    }

}
