package com.yuan.spring.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Pet{
    private String name;

    public Pet(@Value("tom") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}


@Component
public class People {

    private Pet pet;

    public People(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "People{" +
                "pet=" + pet +
                '}';
    }
}
