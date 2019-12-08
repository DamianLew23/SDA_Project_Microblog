package sda.project.microblog.service.utils;

import org.springframework.stereotype.Service;
import sda.project.microblog.dto.PostDto;
import sda.project.microblog.model.Post;

@Service
public class PostConverter {

    public PostDto convertDaoToDto(Post post) {

        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setContent(post.getContent());

        return postDto;
    }

    public Post convertDtoToDao(PostDto postDto) {

        Post post = new Post();

        post.setContent(postDto.getContent());

        return post;
    }
}
