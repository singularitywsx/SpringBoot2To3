package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    /**
     * http://localhost:8081/redis/Redis
     * 回傳 {Hello, Redis!}
     *
     * http://localhost:8081/redis/xxx
     * 回傳 404
     * */
    @GetMapping("/{key}")
    public String getValue(@PathVariable String key) {
        return redisService.getValue(key);
    }

}
