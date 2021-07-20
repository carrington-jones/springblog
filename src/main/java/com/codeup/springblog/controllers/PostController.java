package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable int id){
        return "This is the post for id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Create a post form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String publishPost(){
        return "Posting of the form on /posts/create";
    }
}
