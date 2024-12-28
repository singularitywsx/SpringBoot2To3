package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 定義 Feign 客戶端，baseUrl
@FeignClient(name = "postsClient", url = "${feign.client.url}")
public interface PostsClient {

    @GetMapping("/posts/{id}")
    Post getPosts(@PathVariable Long id);
}