package com.github.mrcaoyc.demo.controller;

import com.github.mrcaoyc.keygen.KeyGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CaoYongCheng
 */
@RestController
public class HelloController {
    private final KeyGenerator keyGenerator;

    public HelloController(KeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    @GetMapping("/hello")
    public Object helloMessage() {
        return keyGenerator.generateKey();
    }
}
