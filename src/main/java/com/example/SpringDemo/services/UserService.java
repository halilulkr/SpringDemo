package com.example.SpringDemo.services;

import com.example.SpringDemo.dtos.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserService {

    //http://localhost:8080/user/list
    @GetMapping(value = "/user/list")
    public List<UserDto> getUserList(){
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(UserDto.builder().firstName("Halil").lastName("Ülker").build());
        userDtoList.add(UserDto.builder().firstName("Merve").lastName("Ülker").build());
        return userDtoList;
    }
}
