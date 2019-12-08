package sda.project.microblog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.project.microblog.dto.UserDto;
import sda.project.microblog.model.User;
import sda.project.microblog.repository.UserRepository;
import sda.project.microblog.service.utils.UserConverter;

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

    public UserDto addUserDto(UserDto userDto){
        User user = userConverter.convertDtoToDao(userDto);
        User userSaved = userRepository.save(user);
        UserDto userDtoSaved = userConverter.convertDaoToDto(userSaved);
        return userDtoSaved;
    }
}
