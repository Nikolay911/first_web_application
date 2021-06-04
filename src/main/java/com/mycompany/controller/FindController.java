package com.mycompany.controller;


import com.mycompany.model.User;
import com.mycompany.model.StringFind;
import com.mycompany.secondaryfunction.Secondary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class FindController {

    @GetMapping("/find-by-surname")
    public String findSurname(Model model){
        User grObj1 = new User();
        model.addAttribute("user", grObj1);
        return "find-by-surname";
    }

    @PostMapping("/find")
    public String find(@ModelAttribute User user, StringFind stringFind,
                       HttpServletRequest request, HttpServletResponse response){
        stringFind.setStringFind(Secondary.requestNameSurname("f1.txt", user.getSurname(), user.getName()));
        if(stringFind.getStringFind().equals("Not-found"))
            return "Not-found";

        HttpSession session = request.getSession(true);

        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String brouser = request.getHeader("User-Agent");

        stringFind.setStringFind(stringFind.getStringFind()+
                "\n"+"      Access Time: " + lastAccessTime + ", Brouser: " + brouser);
        return "find";
    }
}
