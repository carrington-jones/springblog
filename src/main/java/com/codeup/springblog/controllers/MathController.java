package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    //ADD
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNumbers(@PathVariable int num1, @PathVariable int num2) {
        String x = String.valueOf(num1 + num2);
        return x;
    }

    //SUBTRACT
    @GetMapping("/subtract/{num3}/from/{num4}")
    @ResponseBody
    public String subtractNumbers(@PathVariable int num3, @PathVariable int num4) {
        String x = String.valueOf(num4 - num3);
        return x;
    }

    //MULTIPLY
    @GetMapping("/multiply/{num5}/and/{num6}")
    @ResponseBody
    public String multiplyNumbers(@PathVariable int num5, @PathVariable int num6) {
        String x = String.valueOf(num5 * num6);
        return x;
    }

    //DIVIDE
    @GetMapping("/divide/{num7}/by/{num8}")
    @ResponseBody
    public String divideNumbers(@PathVariable int num7, @PathVariable int num8) {
        String x = String.valueOf(num7 / num8);
        return x;
    }
}


