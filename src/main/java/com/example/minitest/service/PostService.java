package com.example.minitest.service;

import com.example.minitest.model.Post;

import java.util.Optional;

public interface PostService {
    Iterable<Post> findAll();
    Optional findById(Long id);
    void save(Post post);
    void delete(Long id);

}
