package com.example.demo.service;

import com.example.demo.client.Post;
import com.example.demo.client.PostsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

   @Autowired
   PostsClient postsClient;

    public Post getPosts(final Long id) {
        return postsClient.getPosts(id);
    }

}
