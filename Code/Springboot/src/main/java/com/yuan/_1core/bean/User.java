package com.yuan._1core.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String name;
    private Integer age;
    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
