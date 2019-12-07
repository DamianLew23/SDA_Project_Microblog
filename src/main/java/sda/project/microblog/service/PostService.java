package sda.project.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import sda.project.microblog.dto.PostDto;
import sda.project.microblog.model.Post;
import sda.project.microblog.repository.PostRepository;

import java.util.List;
import java.util.Map;

public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post createdPost(Post post) {
        return postRepository.save(post);
    }

    public List<PostDto> allPostList() {
        List<Post> allPostsList = postRepository.findAll();
        return null;

    }
}