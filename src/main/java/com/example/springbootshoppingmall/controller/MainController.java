package com.example.springbootshoppingmall.controller;

import com.example.springbootshoppingmall.dto.UserDto;
import com.example.springbootshoppingmall.entity.UserEntity;
import com.example.springbootshoppingmall.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private UserRepository userRepository;
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/jcowwk")
    public String Main(){
        return "main";
    }

    @GetMapping("/loginpage")
    public String LoginPage(){
        return "user/loginpage";
    }

    @GetMapping("/joinpage")
    public String JoinPage(){
        return "user/joinpage";
    }

    @PostMapping("/join")
    public String Join(UserDto userDto){
        UserEntity userEntity = userDto.toEntity();

        if (userRepository.findById(userEntity.getId()) == null){
            userRepository.save(userEntity);
        }
        else {
            log.info("check your id");
            return "redirect:/joinpage";
        }
        return "user/loginpage";
    }

    @PostMapping("/login")
    public String Login(UserDto userDto){
        UserEntity userEntity = userDto.toEntity();

        if (userRepository.findById(userEntity.getId()).equals(userEntity.getId()) && userRepository.findById(userEntity.getPw()).equals(userEntity.getPw())) {
            log.info("success login!");
        }
        return "main";
    }
}