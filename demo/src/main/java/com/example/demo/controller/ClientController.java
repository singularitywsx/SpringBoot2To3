package com.example.demo.controller;

import com.example.demo.client.Post;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

   @Autowired
   ClientService clientService;

    /**
     * http://localhost:8081/api/users/1
     * 回傳
     * {
     *   "userId": 1,
     *   "id": 1,
     *   "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
     *   "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
     * }
     *
     * */
    @GetMapping("/api/users/{id}")
    public ResponseEntity<Post> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getPosts(id));
    }

}
