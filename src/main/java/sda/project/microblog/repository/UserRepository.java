package sda.project.microblog.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.project.microblog.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
