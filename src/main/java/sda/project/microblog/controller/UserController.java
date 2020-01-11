package sda.project.microblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import sda.project.microblog.dto.UserDto;
import sda.project.microblog.dto.UserDtoRegistration;
import sda.project.microblog.model.User;
import sda.project.microblog.repository.UserRepository;
import sda.project.microblog.service.UserService;
import sda.project.microblog.service.exceptions.DuplicateLoginAndUserNameException;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }


    @ExceptionHandler({DuplicateLoginAndUserNameException.class})
    public ResponseEntity handleDuplicateLoginAndUser(DuplicateLoginAndUserNameException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.IM_USED);
    }

    @PostMapping(value = "/user/registration")
    @ResponseBody
    ResponseEntity<UserDtoRegistration> addUser(@RequestBody UserDtoRegistration userDtoRegistration) throws DuplicateLoginAndUserNameException {
        UserDtoRegistration userDtoSaved = userService.addUserDto(userDtoRegistration);
        return new ResponseEntity<>(userDtoSaved, HttpStatus.CREATED);
    }


    @GetMapping(value = "/users")
    List<UserDto> allUsersList() {
        return userService.allUsersList();
    }

    @GetMapping(value = "/users", params = {"userName"})
    @ResponseBody
    public UserDto findUserByUserName(@RequestParam(name = "userName") String userName) {
        return userService.findUserByUserName(userName);
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }


}