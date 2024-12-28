package com.example.demo.init;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisDataInitializer implements CommandLineRunner {

    @Autowired
    private RedisService redisService;

    @Override
    public void run(String... args) {
        try {
            redisService.setValue("Redis", "Hello, Redis!");
        } catch (Exception e) {
            throw new RuntimeException("Redis data initialized!");
        }
    }
}
