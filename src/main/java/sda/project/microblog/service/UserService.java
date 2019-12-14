package sda.project.microblog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.project.microblog.dto.UserDto;
import sda.project.microblog.dto.UserDtoRegistration;
import sda.project.microblog.model.User;
import sda.project.microblog.repository.UserRepository;
import sda.project.microblog.service.utils.UserConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User saveUser(User user) {
        return null;
    }

    public UserDtoRegistration addUserDto(UserDtoRegistration userDtoRegistration) {
        User user = userConverter.convertDtoToDao(userDtoRegistration);
        User userSaved = userRepository.save(user);
        UserDtoRegistration userDtoSaved = userConverter.convertDaoToDtoRegistration(userSaved);
        return userDtoSaved;
    }


    public List<UserDto> allUsersList() {
        List<User> allUsersList = userRepository.findAll();


        List<UserDto> allUsersDtoList = allUsersList
                .stream()
                .map(u -> userConverter.convertDaoToDto(u))
                .collect(Collectors.toList());

        return allUsersDtoList;
    }


}

