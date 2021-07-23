package com.codeup.springblog.controllers;


import com.codeup.springblog.models.AdRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id, Model model){
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id,
                         @RequestParam String title,
                         @RequestParam String body) {
        Post postToUpdate = new Post(
                id,
                title,
                body
        );
        postDao.save(postToUpdate);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Create a post form";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String publishPost(){
        return "Posting of the form on /posts/create";
    }
}
