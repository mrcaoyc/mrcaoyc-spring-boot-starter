package com.github.mrcaoyc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CaoYongCheng
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object helloMessage(String name, Integer age, Integer height) {
        Integer.parseInt(name);
        return "name=" + name + ",age=" + age;
    }
}
