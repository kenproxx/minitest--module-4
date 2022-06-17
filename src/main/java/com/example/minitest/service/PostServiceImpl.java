package com.example.minitest.service;

import com.example.minitest.model.Post;
import com.example.minitest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostServiceImpl implements PostService {
@Autowired
private PostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> search(String title) {
        return postRepository.findAllByTitleContaining(title);
    }

    public List<Post> findAllByOrderByLikesDesc() {
        return postRepository.findAllByOrderByLikesDesc();
    }

    public List<Post> findAllByOrderByCreatedAtDesc() {
        return postRepository.findAllByOrderByCreateAtDesc();
    }
}
