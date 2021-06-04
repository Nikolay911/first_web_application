package com.mycompany.controller;

import com.mycompany.model.User;
import com.mycompany.secondaryfunction.Secondary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserController {

    @GetMapping("/user-add")
    public String greetingSubmit(Model model) {
        User grObj = new User();
        model.addAttribute("user", grObj);

        return "user-add";
    }

    @PostMapping("/submit-user")
    public String greetingSubmit(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || Secondary.validationFields(user)==false) {
            return "user-add";
        }
        Secondary.UploadData(user);
        return "result";
    }

}

