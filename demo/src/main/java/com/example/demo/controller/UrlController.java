package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlController {

    /** Spring boot 2 以下兩種路徑都回出同樣結果
     * http://localhost:8081/url/resources
     * http://localhost:8081/url/resources/
     * */
    @GetMapping("/resources")
    String resources() {
        return "Hello from /resources";
    }


}
