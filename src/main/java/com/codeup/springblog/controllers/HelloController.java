package com.codeup.springblog.controllers;


import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    private final EmailService emailSVC;

    public HelloController(EmailService emailSVC){
        this.emailSVC = emailSVC;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return"<h1>Hello from Spring!</h1>";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "Hello";
    }

    @GetMapping("/join")
    public String showJoinForm(){
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        emailSVC.prepareAndSend("test@test.com", "Hello welcome to Neptune!", "Thank you for attending our web development program");
        return "join";
    }

    @GetMapping("/number/{num}")
    @ResponseBody
    public String displayNumber(@PathVariable int num){
        return String.valueOf(num);
    }

    @RequestMapping(path = "/hello/in/{color}", method = RequestMethod.GET) //Another syntax for GetMapping
    @ResponseBody
    public String helloInColor(@PathVariable String color){
        return "<h1 style=\"color: " + color + "\">Hello in " + color + "!</h1>";
    }

}
