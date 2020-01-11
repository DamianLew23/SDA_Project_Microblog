package sda.project.microblog.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.project.microblog.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    User findFirstByLogin(String loginText);
    User findFirstByUserName(String userNameText);
}

