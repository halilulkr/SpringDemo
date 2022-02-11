package com.example.SpringDemo.controllers;

import com.example.SpringDemo.dtos.UserDto;
import com.example.SpringDemo.entities.User;
import com.example.SpringDemo.repositories.UserDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@Controller
@Log4j2
public class UserController {

    @Autowired
    private UserDao userDao;

    // http://localhost:8080/register
    @GetMapping("/register")
    public String getForm(Model model) {
        model.addAttribute("key_form", new UserDto());
        return "register";
    }

    // http://localhost:8080/register
    @PostMapping("/register")
    public String postForm(@Valid @ModelAttribute("key_form") UserDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(dto);
            return "register";
        }
        //database yazılacak alan
        User user = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();

        userDao.save(user);
        log.info(dto);
        return "success";
    }

    // http://localhost:8080/view
    @GetMapping("/view")
    @ResponseBody
    public List<User> getUser() {
        return this.userDao.findAll();
    }

    //http://localhost:8080/user/controller
    @GetMapping(value = "/user/controller")
    @ResponseBody
    public String getUserFromUserService(){
        String URL="http://localhost:8080/user/list";
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(URL, String.class);
        log.info(jsonData.trim());
        return jsonData;
    }

}
