package com.example.minitest.controller;

import com.example.minitest.model.Post;
import com.example.minitest.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list", postService.findAll());
        return mav;
    }

    //edit
    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("edit");
        Optional post = postService.findById(id);
        mav.addObject("post", post.get());
        return mav;
    }

    @PostMapping("{id}/edit")
    public ModelAndView edit(@ModelAttribute Post post) {
        ModelAndView mav = new ModelAndView("redirect:/");
        postService.save(post);
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String title) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list", postService.search(title));
        return mav;
    }

    @GetMapping("/sort")
    public ModelAndView sort() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list", postService.findAllByOrderByLikesDesc());
        return mav;
    }

    @GetMapping("/sort2")
    public ModelAndView sortByCreateAt() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list", postService.findAllByOrderByCreatedAtDesc());
        return mav;
    }
}
