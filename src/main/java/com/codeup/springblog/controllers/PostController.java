package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public String posts(Model model) {

        posts.add(new Post("testing title", "testing body"));
        posts.add(new Post("testing title2", "testing body2"));
        model.addAttribute("post",posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable int id, Model model){
        Post post = new Post("requested post", "requested body");
        model.addAttribute("post", post);
        return "posts/show";
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
