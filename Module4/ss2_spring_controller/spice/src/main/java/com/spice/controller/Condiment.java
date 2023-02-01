package com.spice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class Condiment {
    @GetMapping("")
    public String showCondiments() {
        return "index";
    }

    @GetMapping("/condiment")
    public String showResult(Model model, @RequestParam(value = "condiment", required = false, defaultValue = "no condiment") String[] condiments) {
        model.addAttribute("result", Arrays.toString(condiments));
        model.addAttribute("pre", "Sandwich condiment: ");
        return "index";
    }
}
