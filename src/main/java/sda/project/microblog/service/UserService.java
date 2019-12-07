package sda.project.microblog.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import sda.project.microblog.repository.UserRepository;


public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
