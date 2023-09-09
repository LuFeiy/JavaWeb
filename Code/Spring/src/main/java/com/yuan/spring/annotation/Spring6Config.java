package com.yuan.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.yuan.spring")
@EnableAspectJAutoProxy
public class Spring6Config {
    @Bean(name = "petTom")
    public Pet petTom() {
        return new Pet("Tom");
    }

    @Bean(name = "petJerry")
    public Pet petJerry() {
        return new Pet("Jerry");
    }
}
