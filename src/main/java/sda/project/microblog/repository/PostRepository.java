package sda.project.microblog.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.project.microblog.model.Post;

import java.util.List;

@Repository

public interface PostRepository extends CrudRepository<Post , Long> {
    List<Post> findAll();
}
