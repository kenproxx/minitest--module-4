package com.example.minitest.repository;

import com.example.minitest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    Post findByTitle(String title);
    List<Post> findAllByTitleContaining(String title);

    //sort list post by likes
    List<Post> findAllByOrderByLikesDesc();

    //sort list post by createdAt
    List<Post> findAllByOrderByCreateAtDesc();


}
