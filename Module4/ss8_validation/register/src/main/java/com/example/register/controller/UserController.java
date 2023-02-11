package com.example.register.controller;

import com.example.register.dto.UserDto;
import com.example.register.model.User;
import com.example.register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/index";
    }

    @PostMapping("register")
    public String create(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "index";
        } else if (userService.check(userDto.getEmail())) {
            bindingResult.rejectValue("email", "hhhh", "Email trùng lặp");
            return "index";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            return "redirect:/list";
        }
    }
}



