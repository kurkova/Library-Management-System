package com.project.library.controller;


import com.project.library.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void createUse (UserDto userDto){
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUsers (){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public UserDto getUser (){
        return new UserDto(1L, "Paula", "kur", LocalDate.of(2018,3,23));
    }
}

