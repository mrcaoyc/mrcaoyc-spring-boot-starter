package com.github.mrcaoyc.demo.controller;

import com.github.mrcaoyc.demo.controller.demo.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author CaoYongCheng
 */
@RestController
public class HelloController {

    @PostMapping("/hello")
    public Object helloMessage(@Valid @RequestBody User user) {
        return user;
    }
}
