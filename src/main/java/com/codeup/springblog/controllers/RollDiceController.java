package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class RollDiceController {
    @GetMapping(value = "/roll-dice")
    public String diceRoll() {
        return "roll-dice";
    }
    @GetMapping(value = "/roll-dice/{guess}")
    public String diceRollResults(@PathVariable int guess, Model model) {
        int randomNumberRolled = (int) (Math.random() * ((6 - 1) + 1) + 1);
        model.addAttribute("guess", "This is your " + guess);
        model.addAttribute("randomRoll", randomNumberRolled);
        model.addAttribute("isCorrect", guess == randomNumberRolled);

        if(guess == randomNumberRolled){
            model.addAttribute("correctRoll", "You rolled correctly");
            model.addAttribute("correctRoll", "You Win!\nYou guessed the number " + guess + " and rolled the number " + randomNumberRolled);
        }
        else {
            model.addAttribute("incorrectRoll", "Pick again");
            model.addAttribute("correctRoll", "You guessed the number " + guess + " and rolled the number " + randomNumberRolled);
        }
        return "roll-dice";
    }
}
