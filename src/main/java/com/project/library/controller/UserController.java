package com.project.library.controller;
import com.project.library.controller.Exception.BookNotFoundException;
import com.project.library.controller.Exception.UserNotFoundException;
import com.project.library.dto.UserDto;
import com.project.library.mapper.UserMapper;
import com.project.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user", consumes = APPLICATION_JSON_VALUE )
    public void addUser (@RequestBody UserDto userDto) throws UserNotFoundException, BookNotFoundException {
        userService.saveUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUsers (){
       return  userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public UserDto getUser (@RequestParam Long idUser) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUser(idUser));
    }
}

