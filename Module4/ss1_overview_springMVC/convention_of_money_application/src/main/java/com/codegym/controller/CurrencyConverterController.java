package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {
    @GetMapping("/")
    public String convert() {
        return "index";
    }
    @PostMapping("/vnd")
    public String submit(@RequestParam String number,Model model){
        float currencyConvert = Float.parseFloat(number)* 25.5042f;
        model.addAttribute("result",currencyConvert);
        model.addAttribute("usd",number);
        return "result";
    }
}
