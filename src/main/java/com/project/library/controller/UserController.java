//package com.project.library.controller;
//import com.project.library.dto.UserDto;
//import com.project.library.mapper.UserMapper;
//import com.project.library.service.UserService;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//
//
//@RestController
//@RequestMapping("/v1")
//public class UserController {
//    private UserService userService;
//
//    private UserMapper userMapper;
//
//
//    @RequestMapping(method = RequestMethod.POST, value = "/user", consumes = JSON )
//    public void createUse (@RequestBody UserDto userDto){
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/users")
//    public List<UserDto> getUsers (){
//       return  userMapper.mapToUserDtoList(userService.getAllUsers());
//    }
//
//
//    @RequestMapping(method = RequestMethod.GET, value = "/user")
//    public UserDto getUser (){
//        return new UserDto(1L, "Paula", "kur", LocalDate.of(2018,3,23));
//    }
//}
//
