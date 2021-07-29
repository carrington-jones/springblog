package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao; //Injecting User Repository
    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping(value = "/posts/create")
    public String createPost(Model model) {
        model.addAttribute("createPost", new Post());
        emailService.prepareAndSend("test@test.com", "Thank you for creating a new post", "Thank you for adding to our blog");
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        User user = userDao.getById(1L);
        Post post = new Post(title, body, user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id,
                         @RequestParam String title,
                         @RequestParam String body,
                         @RequestParam User user) {
        Post postToUpdate = new Post(
                id,
                title,
                body,
                user
        );
        postDao.save(postToUpdate);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }
}
