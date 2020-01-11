package sda.project.microblog.api;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sda.project.microblog.dto.PostDto;
import sda.project.microblog.model.Post;
import sda.project.microblog.model.User;
import sda.project.microblog.repository.PostRepository;
import sda.project.microblog.repository.UserRepository;
import sda.project.microblog.service.PostService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostConstruct
    public void postConstruct() {
        User user1 = new User("user1", passwordEncoder.encode("1"), "uzytkownik1");
        User user2 = new User("user2", passwordEncoder.encode("2"), "uzytkownik2");
        User user3 = new User("user3", passwordEncoder.encode("3"), "uzytkownik3");
        User user4 = new User("user4", passwordEncoder.encode("4"), "uzytkownik4");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        userRepository.saveAll(userList);

        User user = userRepository.findFirstByLogin("user1");
        Post post = new Post("Ciekawe czy działa",user);
        Post post1 = new Post("Janikowski został znokautowany",user);
        Post post2 = new Post("Ho ho ho",user);
        Post post3 = new Post("ładna pogoda",user);
        Post post4 = new Post("Władek",user);

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
    ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto) throws IOException {
        PostDto postDtoSaved = postService.addPostDto(postDto);
        return new ResponseEntity<>(postDtoSaved, HttpStatus.CREATED);
    }
}
