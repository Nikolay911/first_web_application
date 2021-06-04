package com.mycompany.controller;


import com.mycompany.model.MailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Properties;

@Controller
public class MailController {

    @GetMapping("/mailpage")
    public String greetingSubmit(Model model){

        MailMessage mailMessage = new MailMessage();
        model.addAttribute("message", mailMessage);
        return "mailpage";
    }

    @PostMapping("/sucsess-mail")
    public String greetingSubmit(@ModelAttribute MailMessage mailMessage)  throws MessagingException, IOException {

        final Properties properties = new Properties();
        properties.load(MailController.class.getClassLoader().getResourceAsStream("mail.properties"));
        mailMessage.sendMessage(properties);
        return "sucsess-mail";
    }

}
