package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 定義 Feign 客戶端，baseUrl
@FeignClient(name = "postsClient", url = "${feign.client.url}")
public interface PostsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{id}")
    Post getPosts(@PathVariable("id") Long id);
}