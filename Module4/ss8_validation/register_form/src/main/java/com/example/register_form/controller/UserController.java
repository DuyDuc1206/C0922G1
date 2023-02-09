package com.example.register_form.controller;

import com.example.register_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("users",userService.findAll());
        return "list";
    }

}
