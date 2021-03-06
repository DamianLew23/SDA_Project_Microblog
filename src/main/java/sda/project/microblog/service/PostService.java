package sda.project.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sda.project.microblog.dto.PostDto;
import sda.project.microblog.model.Post;
import sda.project.microblog.model.User;
import sda.project.microblog.repository.PostRepository;
import sda.project.microblog.repository.UserRepository;
import sda.project.microblog.service.utils.PostConverter;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PostConverter postConverter;

    @Autowired
    PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<PostDto> allPostList() {
        List<Post> allPostsList = postRepository.findAll();

        return allPostsList
                .stream()
                .map(x -> postConverter.convertDaoToDto(x))
                .collect(Collectors.toList());

    }

    public PostDto addPostDto(PostDto postDto) {
        Post post = postConverter.convertDtoToDao(postDto);
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findFirstByLogin(userLogin);
        post.setUser(user);
        Post postSaved = postRepository.save(post);
        return postConverter.convertDaoToDto(postSaved);
    }
}