package com.project.library.mapper;

import com.project.library.domain.User;
import com.project.library.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
//    public User mapToUser(final UserDto userDto) {
//        return new User(
//                userDto.getId(),
//                userDto.getName(),
//                userDto.getLastName(),
//                userDto.getCreatedAccount()
//        );
//    }

//    public UserDto mapToUserDto(final User user) {
//        return new UserDto(
//                user.getId(),
//                user.getName(),
//                user.getLastName(),
//                user.getCreatedAccount()
//        );
//    }
//
//    public List<UserDto> mapToUserDtoList(final List<User> userList) {
//        return userList.stream()
//                .map(u -> new UserDto(u.getId(), u.getName(), u.getLastName(), u.getCreatedAccount()))
//                .collect(Collectors.toList());
//    }
}
