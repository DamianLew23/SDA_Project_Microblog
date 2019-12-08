package sda.project.microblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sda.project.microblog.model.User;
import sda.project.microblog.repository.UserRepository;
import sda.project.microblog.service.UserService;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user){return userService.addUser(user);}

    @PostConstruct
    public void userConstruct(){
        User user1 = new User("User1","1","Uzytkownik1");
        User user2 = new User("User2","2","Uzytkownik2");
        User user3 = new User("User3","3","Uzytkownik3");
        User user4 = new User("User4","4","Uzytkownik4");

        List <User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        userRepository.saveAll(userList);
    }


}
