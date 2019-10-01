package com.project.library.controller;


import com.project.library.domain.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "/postUser")
    public void createUse (UserDto userDto){
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public List<UserDto> getUsers (){
        return new ArrayList<>();
    }


}

