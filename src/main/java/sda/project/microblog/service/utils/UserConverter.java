package sda.project.microblog.service.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.project.microblog.dto.UserDto;
import sda.project.microblog.dto.UserDtoRegistration;
import sda.project.microblog.model.User;

@Service
public class UserConverter {
@Autowired
PasswordEncoder passwordEncoder;
    public User convertDtoToDao(UserDtoRegistration userDtoRegistration) {
        User user = new User();


        user.setLogin(userDtoRegistration.getLogin());
        user.setPassword(passwordEncoder.encode(userDtoRegistration.getPassword()));
        user.setUserName(userDtoRegistration.getUserName());

        return user;

    }

    public UserDtoRegistration convertDaoToDtoRegistration(User user) {

        UserDtoRegistration userDtoRegistration = new UserDtoRegistration();

        userDtoRegistration.setId(user.getId());
        userDtoRegistration.setLogin(user.getLogin());
        userDtoRegistration.setPassword(user.getPassword());
        userDtoRegistration.setUserName(user.getUserName());

        return userDtoRegistration;
    }

    public UserDto convertDaoToDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setUserName(user.getUserName());

        return userDto;
    }
}
