package com.nullvoidkage.user.controller;

import com.nullvoidkage.user.VO.RestTemplateVO;
import com.nullvoidkage.user.entity.User;
import com.nullvoidkage.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public RestTemplateVO getUserWithDepartment(@PathVariable("id") Long id){
        log.info("Inside saveUser of UserController");
        return userService.getUserWithDepartment(id);
    }



}
