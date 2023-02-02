package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @ModelAttribute("languages")
    public String[] listLanguage() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] pageSize() {
        return new int[]{5, 10, 15, 20};
    }

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("email", new Email());
        return "index";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("email",email);
        model.addAttribute("mess","Edit successfully");
        return "list";
    }
}
