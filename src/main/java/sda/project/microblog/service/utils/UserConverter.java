package sda.project.microblog.service.utils;


import org.springframework.stereotype.Service;
import sda.project.microblog.dto.UserDto;
import sda.project.microblog.model.User;

@Service
public class UserConverter {

    public User convertDtoToDao(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUserName());

        return user;

    }

    public UserDto convertDaoToDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setUserName(user.getUserName());

        return userDto;
    }
}
