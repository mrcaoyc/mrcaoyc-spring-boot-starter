package com.github.mrcaoyc.demo.controller.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author CaoYongCheng
 */
public class User {

    @NotEmpty(message = "参数不能为空")
    private String name;
    @Min(20)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
